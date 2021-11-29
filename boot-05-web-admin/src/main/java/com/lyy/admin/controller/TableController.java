package com.lyy.admin.controller;

import com.lyy.admin.bean.User;
import com.lyy.admin.exception.UserTooManyException;
import com.lyy.admin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Arrays;
import java.util.List;

/**
 * @program: boot-05-web-admin
 * @description:
 * @author: ly
 * @create: 2021-11-25 15:13
 **/
@Controller
public class TableController {
    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){

        return "redirect:/dynamic_table";

    }



    @GetMapping("/basic_table")
    public String basic_table(){
        return "table/basic_table";
    }
    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model){
//        //表格内容的遍历
////        List<User> users = Arrays.asList(new User("zhangsan", "123456"), new User("lisi", "123444"), new User("wangwu", "aaaaaa"));
//        model.addAttribute("users",users);
//if (users.size()>3){
//    throw new UserTooManyException();

//}
        //从数据库中查出user表中的用户进行展示
        return "table/dynamic_table";
    }
    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }
    @GetMapping("/editable_tablle")
    public String editable_table(){
        return "table/editable_table";
    }
}
