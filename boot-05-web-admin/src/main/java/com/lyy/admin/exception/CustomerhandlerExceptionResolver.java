package com.lyy.admin.exception;

import lombok.SneakyThrows;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: boot-05-web-admin
 * @description:
 * @author: ly
 * @create: 2021-11-26 16:30
 **/

/**
 *自定义的异常解析器
 */
@Order(value = Ordered.HIGHEST_PRECEDENCE)//优先级，数字越小，优先级越高
@Component
public class CustomerhandlerExceptionResolver implements HandlerExceptionResolver {
    @SneakyThrows
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler, Exception ex) {
        response.sendError(511,"我喜欢的错误");
        return new ModelAndView();
    }
}
