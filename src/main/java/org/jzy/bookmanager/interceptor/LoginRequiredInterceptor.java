package org.jzy.bookmanager.interceptor;

import org.jzy.bookmanager.exception.BusinessExceptions;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户登录拦截器
 * @author Fresh0range
 * @since 2020/10/17
 */
public class LoginRequiredInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        var session = request.getSession();
        var user = session.getAttribute("user");
        if (user == null) {
            throw BusinessExceptions.LOGIN_REQUIRED;
        } else {
            return true;
        }
    }
}
