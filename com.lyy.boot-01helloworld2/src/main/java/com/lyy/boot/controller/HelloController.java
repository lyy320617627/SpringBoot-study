package com.lyy.boot.controller;

import com.lyy.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: boot-01-helloworld-2
 * @description:
 * @author: ly
 * @create: 2021-11-22 20:06
 **/
@RestController
public class HelloController {
    @Autowired
    Person person;
    @RequestMapping("/person")
    public Person person(){
        return person;
    }
}
