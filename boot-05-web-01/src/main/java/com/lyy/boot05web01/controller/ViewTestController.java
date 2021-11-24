package com.lyy.boot05web01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: boot-05-web-01
 * @description:
 * @author: ly
 * @create: 2021-11-24 19:37
 **/
@Controller
public class ViewTestController {
    @GetMapping("/atguigu")
    public String atguigu(Model model){
//       model请求域中的数据会被放到请求域中request.setAttribute("a",aa);
        model.addAttribute("msg","你好，李杨杨");
        model.addAttribute("Link","http://www.baidu.com");
     return "success";
    }
}
