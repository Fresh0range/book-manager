package org.jzy.bookmanager.admin.interceptor;

import org.jzy.bookmanager.exception.BusinessExceptions;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminLoginRequiredInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        var session = request.getSession();
        var adminUser = session.getAttribute("adminUser");
        if (adminUser == null) {
            throw BusinessExceptions.LOGIN_REQUIRED;
        } else {
            return true;
        }
    }
}
