package com.lyy.boot05web01.controller;

import com.lyy.boot05web01.bean.Person;
import org.omg.CORBA.INTERNAL;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.rmi.MarshalledObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: boot-05-web-01
 * @description:
 * @author: ly
 * @create: 2021-11-23 16:15
 *
 *
 **/
@RestController
public class ParamterTestController {
    /**
     * 数据绑定，页面提交的请求数据（GET、POST）都可以和对象属性进行绑定
     * @param person
     * @return
     */
    @PostMapping("/saveuser")
    public Person saveuser(Person person){
        return person;
    }


    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id, @PathVariable("username") String name, @PathVariable() Map<String,String> pv,
                                     @RequestHeader("User-Agent") String userAgent,
                                     @RequestHeader Map<String,String> header,
                                     @RequestParam("age") Integer age,
                                     @RequestParam("inters") List<String> inters,
                                     @RequestParam Map<String,String> params,
                                     @CookieValue("_ga") Cookie cookie
                                     ){
        Map<String,Object> map=new HashMap<>();
//        map.put("id",id);
//        map.put("name",name);
//        map.put("pv",pv);
//        map.put("userAgernt",userAgent);
//        map.put("headers",header);
        map.put("age",age);
        map.put("inters",inters);
        map.put("params",params);
//        map.put("cookie",cookie);
        System.out.println(cookie);
    return map;
    }
    @PostMapping("/save")
    public Map postMethod(@RequestBody String content){
        Map<String, Object> map = new HashMap<>();
        map.put("content",content);
        return  map;

    }
}
