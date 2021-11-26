package com.lyy.admin.interceptor;

/**
 * @program: boot-05-web-admin
 * @description:
 * @author: ly
 * @create: 2021-11-25 18:53
 **/

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *登录检查
 * 1.配置好拦截器要拦截那些内容
 * 2.把这些配置放在容器中
 * 3.
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 目标方法执行之前执行
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        StringBuffer requestURL = request.getRequestURL();
        log.info("拦截的请求路径是{}",requestURL);
        //登录检查逻辑
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser!=null){
            //放行
            return true;
        }
        //拦截住，跳转到登录页面
        session.setAttribute("msg","请先登录");
        request.getRequestDispatcher("/").forward(request,response);
        response.sendRedirect("/");
        //拦截器
        return  false;
    }

    /**
     * 目标方法执行之后执行
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

   log.info("postHandle拦截的请求路径是{}",modelAndView);
    }

    /**
     * 页面渲染之后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion执行的异常{}",ex);
    }
}
