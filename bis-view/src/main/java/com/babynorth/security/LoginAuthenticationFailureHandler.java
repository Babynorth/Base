package com.babynorth.security;


import com.babynorth.common.PropertiesUtils;
import com.babynorth.constant.Constant;
import com.babynorth.util.Utils;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by babynorth on 2017/3/17.
 */
public class LoginAuthenticationFailureHandler implements AuthenticationFailureHandler {



    private String url;
    private String username;

    // 用户非法登录次数上限
    private int loginFailTimesLimit = 5;

    // 用户登录失败次数达到上限后，再次尝试等待时间（单位：分钟）
    private int attempDelay = 30;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException ae) throws IOException, ServletException {

        String code = "";
        String param = "";
        int leftTimes = 4;
        //获取登录用户名
        String userName = request.getParameter(username);
        if(userName != null){
            if(!userName.toLowerCase().equals("zhengbei")){
                code = Constant.LOGIN_ERR_INFO_NAME;
            }
            //捕捉登录异常
            if (ae != null) {
                // 获取到的异常为用户登录超过次数限制
                if (ae instanceof InternalAuthenticationServiceException &&
                        ae.getMessage().indexOf("User Login Failed Times Limit") != -1) {
                        code  = Constant.LOGIN_ERR_INFO_COUNT;

                    // 跳转到登录页所需参数
                    param = "&failTimesLimit=" + loginFailTimesLimit + "&attempDelay=" + attempDelay;
                }
            }


            // 缓存登录失败的IP地址、累计失败次数及最后一次登录失败时间
            if (!Cache.getUserLoginFailRecord().containsKey(userName)) {
                Cache.getUserLoginFailRecord().put(userName, new LoginFailRecord(userName, 1, new Date()));
            } else {
                LoginFailRecord loginFailRecord = Cache.getUserLoginFailRecord().get(userName);
                loginFailRecord.setFailedTimes(loginFailRecord.getFailedTimes() + 1);
                loginFailRecord.setLastFailedTime(new Date());
            }

            // 剩余尝试机会
            leftTimes = loginFailTimesLimit - Cache.getUserLoginFailRecord().get(userName).getFailedTimes();
    }
        if(userName != null ){
            String ip = Utils.getClientIp(request);
        }
        param = param + "&leftTimes=" + leftTimes;


        response.sendRedirect(request.getContextPath() + url + code + param);

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
