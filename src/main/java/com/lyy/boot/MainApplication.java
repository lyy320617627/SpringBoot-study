package com.lyy.boot;

import ch.qos.logback.core.db.DBHelper;
import com.lyy.boot.bean.Pet;
import com.lyy.boot.bean.User;
import com.lyy.boot.config.MyConfig;
import org.apache.tomcat.util.net.openssl.OpenSSLUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

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
//@SpringBootApplication
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.lyy.boot")
public class MainApplication {
    public static void main(String[] args) {
        //返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        //2.查看容器里面的组件
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
     /*  //3.从容器获取组件
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
//        获取组件
        String[] beanNamesForType = run.getBeanNamesForType(User.class);
        System.out.println("=========================");
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
        DBHelper bean1 = run.getBean(DBHelper.class);
//        System.out.println(bean1);*/
//        boolean tom = run.containsBean("tom");
//        System.out.println("容器中的tom组件"+tom);
//        boolean user01 = run.containsBean("user01");
//        System.out.println("容器中user01组件"+user01);
        String[] beanNamesForType = run.getBeanNamesForType(WebMvcProperties.class);
        System.out.println("======"+beanNamesForType.length);
    }

}
