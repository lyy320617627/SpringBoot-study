package com.lyy.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: boot-1-helloworld
 * @description:
 * @author: ly
 * @create: 2021-11-21 15:34
 **/
/*@ResponseBody
@Controller*/
@RestController
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String handle01(){
        return "Hello,SpringBoot2";
    }
}
