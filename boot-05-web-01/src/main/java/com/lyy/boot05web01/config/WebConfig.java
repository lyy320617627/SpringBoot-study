package com.lyy.boot05web01.config;

import com.lyy.boot05web01.bean.Pet;
import com.lyy.boot05web01.converter.LyyMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.UrlBasedViewResolverRegistration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import javax.jws.WebMethod;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                /**
                 * 自定义协商策略
                 * @param configurer
                 */
                @Override
                public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                    Map<String, MediaType> mediaTypeMap=new HashMap<>();
                    mediaTypeMap.put("json",MediaType.APPLICATION_JSON);
                    mediaTypeMap.put("xml",MediaType.APPLICATION_XML);
                    mediaTypeMap.put("gg",MediaType.parseMediaType("application/x-lyy"));
                    //指定支持解那些参数对应的那些媒体类型
                    ParameterContentNegotiationStrategy parameterStrategy = new ParameterContentNegotiationStrategy(mediaTypeMap);
                    HeaderContentNegotiationStrategy headerContentNegotiationStrategy = new HeaderContentNegotiationStrategy();
                    configurer.strategies(Arrays.asList(parameterStrategy,headerContentNegotiationStrategy));
                }

                @Override
                public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                 converters.add(new LyyMessageConverter());
                }

                @Override
                public void configurePathMatch(PathMatchConfigurer configurer) {
                    UrlPathHelper urlPathHelper=new UrlPathHelper();
                    urlPathHelper.setRemoveSemicolonContent(false);
                    configurer.setUrlPathHelper(urlPathHelper);
                }

                @Override
                public void addFormatters(FormatterRegistry registry) {
                    registry.addConverter(new Converter<String, Pet>() {

                        @Override
                        public Pet convert(String source) {
                            if (!StringUtils.isEmpty(source)){
                                Pet pet = new Pet();
                                String[] split = source.split(",");
                                pet.setName(split[0]);
                                pet.setAge(Integer.parseInt(split[1]));
                                return pet;
                            }
                            return null;
                        }
                    });
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
