package com.lyy.boot;

import com.lyy.boot.bean.Pet;
import com.lyy.boot.bean.User;
import com.lyy.boot.config.MyConfig;
import org.apache.tomcat.util.net.openssl.OpenSSLUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @program: boot-1-helloworld
 * @description:
 * @author: ly
 * @create: 2021-11-21 15:29
 **/

/**
 * 主程序类
 * @SpringBootApplication：这是一个SpringBoot应用
 */
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        //返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        //2.查看容器里面的组件
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
       //3.从容器获取组件
        Pet tom = run.getBean("tom", Pet.class);
        System.out.println(tom);

        //4.com.lyy.boot.config.MyConfig$$EnhancerBySpringCGLIB$$87b40493@71154f21
        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);
        //@Configuration(proxyBeanMethods = true)代理对象调用方法，SpringBoot总会检查这个组件在容器是否有
        //保持组件单实例
        User user = bean.user01();
        User user1 = bean.user01();
        System.out.println(user==user1);
        User user01 = run.getBean("user01", User.class);
        Pet tom1 = run.getBean("tom", Pet.class);
        System.out.println(user01.getPet() == tom1);
    }
}
