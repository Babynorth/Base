package com.babynorth.base.action;

import com.babynorth.action.BaseAction;
import com.babynorth.util.StringUtil;
import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;
import com.octo.captcha.service.image.ImageCaptchaService;
import org.apache.struts2.config.ParentPackage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhengbei on 2017/2/17.
 */

public class TestAction extends BaseAction {

    public String captcha;

    private ImageCaptchaService jcaptchaService;

    public String test() throws Exception {


        return "success";
    }

    public void test1() throws  Exception {
        ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");

        //属性注入必须要有setter
        ImageCaptchaService jcaptchaService = (ImageCaptchaService)cxt.getBean("jcaptchaService");
        System.out.println(jcaptchaService + "jcaptchaService...");
        System.out.println(this.getSession().getId() + "id");
        if(!StringUtil.isAllNullOrEmpty(captcha)) {
            Boolean flag = jcaptchaService.validateResponseForID(this.getSession().getId(), captcha.toUpperCase());
            System.err.println(flag + "......");
            this.renderText(String.valueOf(flag));
        }
    }

    public String testAcess() throws Exception {
        return "testAcess";
    }


    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

}
