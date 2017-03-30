package com.babynorth.base.action.captcha;

import com.octo.captcha.Captcha;
import com.octo.captcha.service.CaptchaServiceException;
import com.octo.captcha.service.captchastore.CaptchaAndLocale;
import com.octo.captcha.service.captchastore.CaptchaStore;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by Administrator on 2017/3/29 0029.
 */
public class SessionCaptchaStore implements CaptchaStore {


    private HttpServletRequest request;
    private HttpSession store;
    private List<String> keySet;
    // 设置
    public static final String SESSIONCAPTCHA="session_captcha";


    /**
     *   request 直接从前端注入不了
     * @author			tannc
     * @createDate		2015年11月23日下午1:59:44
     * @arithMetic
     * @return
     */
    public HttpServletRequest getRequest() {
        return  ServletActionContext.getRequest();
    }


    public HttpSession getStore() {
        return ServletActionContext.getRequest().getSession();
    }


    /**
     *  构造函数
     * SessionCaptchaStore.
     */
    public SessionCaptchaStore() {
        this.keySet = new ArrayList<String>();
    }

    /**
     * Check if a captcha is stored for this id
     *
     * @return true if a captcha for this id is stored, false otherwise
     */
    public boolean hasCaptcha(String id) {
        return getStore().getAttribute(SESSIONCAPTCHA+id)!=null;
    }

    /**
     * Store the captcha with the provided id as key. The key is assumed to be unique, so if the same key is used twice
     * to store a captcha, the store will return an exception
     *
     * @param id      the key
     * @param captcha the captcha
     *
     * @throws com.octo.captcha.service.CaptchaServiceException if the captcha already exists, or if an error occurs during storing routine.
     */
    public void storeCaptcha(String id, Captcha captcha) throws CaptchaServiceException {
        keySet.add(SESSIONCAPTCHA+id);
        getStore().setAttribute(SESSIONCAPTCHA+id, new CaptchaAndLocale(captcha));
    }

    /**
     * Store the captcha with the provided id as key. The key is assumed to be unique, so if the same key is used twice
     * to store a captcha, the store will return an exception
     *
     * @param id      the key
     * @param captcha the captcha
     * @param locale  the locale used that triggers the captcha generation
     * @throws com.octo.captcha.service.CaptchaServiceException
     *          if the captcha already exists, or if an error occurs during storing routine.
     */
    public void storeCaptcha(String id, Captcha captcha, Locale locale) throws CaptchaServiceException {
        keySet.add(SESSIONCAPTCHA+id);
        getStore().setAttribute(SESSIONCAPTCHA+id, new CaptchaAndLocale(captcha,locale));
    }

    /**
     * Retrieve the captcha for this key from the store.
     *
     * @return the captcha for this id
     *
     * @throws com.octo.captcha.service.CaptchaServiceException if a captcha for this key is not found or if an error occurs during retrieving
     *                                 routine.
     */
    public Captcha getCaptcha(String id) throws CaptchaServiceException {
        Object captchaAndLocale = getStore().getAttribute(SESSIONCAPTCHA+id);
        return captchaAndLocale!=null?((CaptchaAndLocale) captchaAndLocale).getCaptcha():null;
    }

    /**
     * Retrieve the locale for this key from the store.
     *
     * @return the locale for this id, null if not found
     * @throws com.octo.captcha.service.CaptchaServiceException
     *          if an error occurs during retrieving routine.
     */
    public Locale getLocale(String id) throws CaptchaServiceException {
        Object captchaAndLocale = getStore().getAttribute(SESSIONCAPTCHA+id);
        return captchaAndLocale!=null?((CaptchaAndLocale) captchaAndLocale).getLocale():null;
    }

    /**
     * Remove the captcha with the provided id as key.
     *
     * @param id the key
     *
     * @return true if found, false otherwise
     *
     * @throws com.octo.captcha.service.CaptchaServiceException if an error occurs during remove routine
     */
    public boolean removeCaptcha(String id) {
        if (getStore().getAttribute(SESSIONCAPTCHA+id) != null) {
            keySet.remove(SESSIONCAPTCHA+id);
            getStore().removeAttribute(SESSIONCAPTCHA+id);
            return true;
        }
        return false;
    }

    /**
     * get the size of this store
     */
    public int getSize() {
        return keySet.size();
    }

    /**
     * Return all the contained keys
     */
    public Collection getKeys() {
        return keySet;
    }

    /**
     * Empty the store
     */
    public void empty() {
        for (Iterator<String> iterator = keySet.iterator(); iterator.hasNext();) {
            String key = iterator.next();
            keySet.remove(key);
            getStore().removeAttribute(key);
        }
    }

    public void cleanAndShutdown() {
        // TODO Auto-generated method stub

    }

    public void initAndStart() {
        // TODO Auto-generated method stub

    }

}
