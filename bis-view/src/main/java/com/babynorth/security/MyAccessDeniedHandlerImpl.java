package com.babynorth.security;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by babynorth on 2017/3/9.
 */
public class MyAccessDeniedHandlerImpl implements AccessDeniedHandler {

    protected static final Log logger = LogFactory.getLog(MyAccessDeniedHandlerImpl.class);
    private String errorPage;

    public MyAccessDeniedHandlerImpl() {
    }

    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        if(!response.isCommitted()) {
            if(this.errorPage != null) {
                request.setAttribute("SPRING_SECURITY_403_EXCEPTION", accessDeniedException);
                response.setStatus(403);
                RequestDispatcher dispatcher = request.getRequestDispatcher(this.errorPage);
                dispatcher.forward(request, response);
            } else {
                response.sendError(403, accessDeniedException.getMessage());
            }
        }

    }

    public void setErrorPage(String errorPage) {
        if(errorPage != null && !errorPage.startsWith("/")) {
            throw new IllegalArgumentException("errorPage must begin with \'/\'");
        } else {
            this.errorPage = errorPage;
        }
    }
}
