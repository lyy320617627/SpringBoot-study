package com.lyy.admin.config;

import com.lyy.admin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: boot-05-web-admin
 * @description:
 * @author: ly
 * @create: 2021-11-25 18:59
 **/

/**
 *1.编写一个拦截器实现HandleInterceptor接口
 * 2.拦截器注册到容器中（实现WebMvcConfigurer的方法）
 * 3.指定拦截规则【如果是拦截所有，静态资也会被拦截】
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")//这种情况下连静态资源也会拦截
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**");//放行的请求


    }
}
