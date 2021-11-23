package com.lyy.boot05web01.controller;

import org.omg.CORBA.INTERNAL;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: boot-05-web-01
 * @description:
 * @author: ly
 * @create: 2021-11-23 17:52
 **/

@Controller
public class RequestController {
    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request){
        request.setAttribute("msg","成功了...");
        request.setAttribute("code",200);
        return "forward:/success";
    }
    @ResponseBody
    @GetMapping("/success")
    public Map success(@RequestAttribute("msg") String msg,
                       @RequestAttribute("code") Integer code,
                       HttpServletRequest request
                           ){
        Object msg1 = request.getAttribute("msg");
        Map<String,Object> map=new HashMap<>();
        map.put("reqMethod_msg",msg1);
        map.put("annptation_msg",msg);
        return map;
    }
    //SPringBoot默认禁用掉了矩阵变量的功能，我们要手动开启
    //手动开启：原理：对于路径的处理。UrlPathHelper进行解析；
    // removeSemicolonContent（移除分号内容）支持矩阵变量的
    //矩阵变量必须有url路径变量才能够被解析
    @GetMapping("/cars/{path}")
    public Map carsSell(@MatrixVariable("low") Integer low,
                        @MatrixVariable("brand") List<String> brand,
                        @PathVariable("path") String path){
        Map<String,Object> map=new HashMap<>();
        map.put("low",low);
        map.put("brand",brand);
        map.put("path",path);
        return map;
    }
    @GetMapping("/boss/{bossId}/{empId}")
    public Map boss(@MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
                    @MatrixVariable(value = "age",pathVar = "empId") Integer empAGe){
        Map<String,Object> map=new HashMap<>();
        map.put("bossAge",bossAge);
        map.put("empAGe",empAGe);
        return map;
    }
}
