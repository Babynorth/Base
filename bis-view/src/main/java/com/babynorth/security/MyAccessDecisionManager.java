package com.babynorth.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;

import java.util.Collection;

/**
 * Created by babynorth on 2017/3/9.
 */
public class MyAccessDecisionManager  implements AccessDecisionManager {

    private static final Logger log = LoggerFactory.getLogger(MyAccessDecisionManager.class);


    /**
     * 决定本次请求是否有权限，没权限抛出异常
     * @param authentication
     * @param o
     * @param attributes
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> attributes) throws AccessDeniedException, InsufficientAuthenticationException {
        if (null == attributes) {
            return;
        }

        FilterInvocation fi = (FilterInvocation) o;
        try {
            /*authentication = (Authentication) fi.getRequest().getSession().getAttribute("authentication");*/
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception e) {
            //ignore first loading exception.
            return;
        }



        if(authentication.getPrincipal().equals("anonymousUser")){
            throw new InsufficientAuthenticationException("匿名用户访问受限");
        }

        /**
         * 遍历通过该url所需要的resourceCode，当前用户只要有一个匹配上即可通过
         */
        for (ConfigAttribute attribute : attributes) {
            String needRole = attribute.getAttribute();

            if("excluded".equals(needRole)){
                return;
            }


            // authority为用户所被赋予的权限, needRole 为访问相应的资源应该具有的权限。
            for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
                if (needRole.equals(grantedAuthority.getAuthority())){
                    return;
                }

            }
        }

        fi.getRequest().setAttribute("accessDeniedUrl", fi.getRequest().getServletPath());

        throw new AccessDeniedException("权限不足!");
    }

    @Override
    public boolean supports(ConfigAttribute ca) {
        return true;
    }

    @Override
    public boolean supports(Class<?> type) {
        return true;
    }


}
