package com.lyy.boot.controller;

import com.lyy.boot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@Slf4j
@RestController
public class HelloController {
    @Autowired
    Car car;
    @RequestMapping("/car")
    public Car car(){
        return car;
    }




    @ResponseBody
    @RequestMapping("/hello")
    public String handle01(){
        log.info("请求进来了.....");
        return "Hello,SpringBoot2";
    }
}
