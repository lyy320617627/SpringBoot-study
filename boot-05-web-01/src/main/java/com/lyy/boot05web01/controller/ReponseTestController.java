package com.lyy.boot05web01.controller;

import com.lyy.boot05web01.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @program: boot-05-web-01
 * @description:1.浏览器发送请求直接返回xml
 * 2.如果是ajax请求，返回json
 * 3.如果是其他app发请求，返回自定义协商数据
 * 属性值1;属性值2；
 * 步骤：
 * 1.添加自定义的MessageConverter进系统底层
 * 2.系统低层就会统计出所有MessageConverter能操作那些数据
 * 3.客户端内容进行协商
 * @author: ly
 * @create: 2021-11-24 11:01
 **/

@Controller
public class ReponseTestController {
    @ResponseBody
    @GetMapping("/test/person")
      public Person getPerson(){
        Person person = new Person();
        person.setAge(28);
        person.setBirth(new Date());
        person.setUserName("zhangsan");
        return person;
      }
}
