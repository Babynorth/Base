package com.babynorth.base.action.captcha;

import com.babynorth.base.action.BaseAction;
import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;
import com.octo.captcha.service.image.ImageCaptchaService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

/**
 * Created by Administrator on 2017/3/29 0029.
 */
@Controller
public class CaptchaImage extends BaseAction {

    public static final String CAPTCHA_IMAGE_FORMAT = "jpeg";


    public CaptchaImage() {

    }


    public String execute() throws Exception {

        ApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");

        //属性注入必须要有setter
        ImageCaptchaService jcaptchaService = (ImageCaptchaService)cxt.getBean("jcaptchaService");



        HttpServletRequest request = getRequest();
        HttpServletResponse response = getResponse();
        System.out.println(jcaptchaService);

        byte captchaChallengeAsJpeg[] = (byte[]) null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        String captchaId = request.getSession().getId();
        BufferedImage challenge = jcaptchaService.getImageChallengeForID(
                captchaId, request.getLocale());

        ImageIO.write(challenge, CAPTCHA_IMAGE_FORMAT, response.getOutputStream());
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();

        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/" + CAPTCHA_IMAGE_FORMAT);

        ServletOutputStream responseOutputStream = response.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();


        return null;
    }


}
