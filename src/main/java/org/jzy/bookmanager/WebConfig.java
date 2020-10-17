package org.jzy.bookmanager;

import org.jzy.bookmanager.admin.interceptor.AdminLoginRequiredInterceptor;
import org.jzy.bookmanager.interceptor.LoginRequiredInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WEB配置类
 * @author Fresh0range
 * @since 2020/10/17
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    /**
     * 拦截器
     * @param registry 拦截器注册表
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginRequiredInterceptor())
                .addPathPatterns("/api/user/**")
                .excludePathPatterns(new String[]{"/api/user/login", "/api/user/register"});
        registry.addInterceptor(new AdminLoginRequiredInterceptor())
                .addPathPatterns("/api/admin/user/**")
                .excludePathPatterns("/api/admin/user/login");
    }
}
