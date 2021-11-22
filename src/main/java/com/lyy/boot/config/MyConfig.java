package com.lyy.boot.config;

import com.lyy.boot.bean.Pet;
import com.lyy.boot.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: boot-1-helloworld
 * @description:
 * @author: ly
 * @create: 2021-11-22 14:28
 **/

/**
 * 1.配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2.配置类本身也是一个组件
 * 3.proxyBeanMethods:代理bean的方法
 *      Full（proxyBeanMethods = true）、
 *      Lite（proxyBeanMethods = false）
 *      组件依赖
 */
//告诉SpringBoot这是一个配置类==配置文件

@Configuration(proxyBeanMethods = true)
public class MyConfig {
    /**
     * 外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
     * @return
     */
    @Bean()//给容器中添加组件，以方法名作为组件的id，返回类型就是组件类型。返回的值，就是组件在容器中的实例
    public User user01(){
        User user=new User("zhangsan",18);
        //user组件依赖了Pet组件
        user.setPet(tomcat());
    return user;
    }
    @Bean("tom")
    public Pet tomcat(){
        return new Pet("tomcat");
    }

}
