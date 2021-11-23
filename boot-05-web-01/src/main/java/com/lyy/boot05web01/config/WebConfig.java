package com.lyy.boot05web01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.UrlBasedViewResolverRegistration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import javax.jws.WebMethod;

/**
 * @program: boot-05-web-01
 * @description:
 * @author: ly
 * @create: 2021-11-23 15:31
 **/
@Configuration(proxyBeanMethods = false)
public class WebConfig /**implements WebMvcConfigurer*/ {
        @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
            HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
            hiddenHttpMethodFilter.setMethodParam("_m");
        return  hiddenHttpMethodFilter;
    }
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
            return new WebMvcConfigurer() {
                @Override
                public void configurePathMatch(PathMatchConfigurer configurer) {
                    UrlPathHelper urlPathHelper=new UrlPathHelper();
                    urlPathHelper.setRemoveSemicolonContent(false);
                    configurer.setUrlPathHelper(urlPathHelper);
                }
            };
    }
//
//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        UrlPathHelper urlPathHelper = new UrlPathHelper();
//        //设置为不移除；后面的内容。这样矩阵变量才能生效
//        urlPathHelper.setRemoveSemicolonContent(false);
//        configurer.setUrlPathHelper(urlPathHelper);
//    }
}
