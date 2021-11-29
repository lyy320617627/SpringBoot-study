package com.lyy.admin.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: boot-05-web-admin
 * @description:
 * @author: ly
 * @create: 2021-11-29 09:16
 **/
@Configuration
public class MyBatisConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor(){
//        new MybatisPlusIn
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        //设置请求的页面大于最大页后操作，true返回到首页，false继续请求 默认 false
        paginationInterceptor.setOverflow(false);
        //设置最大单页限制数量，默认是五百条，-1不限制
        paginationInterceptor.setLimit(500);
        //开启count的join优化，只针对部分left join
//         paginationInterceptor1 = paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        return paginationInterceptor;
    }
}
