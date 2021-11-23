package com.lyy.boot05web01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: boot-05-web-01
 * @description:
 * @author: ly
 * @create: 2021-11-23 10:49
 **/
@RestController
public class HelloController {
    @RequestMapping("/1.jpg")
    public String hello(){
        return "aaaa";
    }
}
