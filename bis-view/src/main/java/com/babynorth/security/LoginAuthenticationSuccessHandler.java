package com.babynorth.security;

import com.babynorth.util.Utils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by babynorth on 2017/3/17.
 */
public class LoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler {


    private String url;
    private String username;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        String ip = Utils.getClientIp(request);
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(user.getName());

        request.getSession().setAttribute("authentication", authentication);

    	/*
    	 * 暂时不提供用户登录默认显示模块
    	//跳转到用户默认模块
    	if( defaultModule != null && !"".equals(defaultModule)){
    		Module module = moduleService.getModuleById(defaultModule);
    		url = module.getModuleUrl();
    	}else{//如果未设置默认模块，从用户权限中取第一个有URL的模块
    		List<GrantedAuthority> list = (List<GrantedAuthority>) authentication.getAuthorities();
        	for(GrantedAuthority ga : list){
        		if(ga != null){
        			String moduleId = ga.getAuthority();
        			//判断权限已M开头，模块
        			if(moduleId != null && !"".equals(moduleId) && "M".equalsIgnoreCase(moduleId.substring(0,1))){
        				Module module = moduleService.getModuleById(ga.getAuthority());
        				//判断模块有URL
        				if(module.getModuleUrl() != null && !"".equals(module.getModuleUrl())){
        					url = module.getModuleUrl();
        					break;
        				}
        			}
        		}
        	}
    	}
    	*/
        System.out.println(url);
        response.sendRedirect(request.getContextPath()+url);

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
