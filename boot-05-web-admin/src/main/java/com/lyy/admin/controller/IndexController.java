package com.lyy.admin.controller;

import com.lyy.admin.bean.Account;
import com.lyy.admin.bean.City;
import com.lyy.admin.bean.User;
import com.lyy.admin.service.AccountService;
import com.lyy.admin.service.CityService;
import com.lyy.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @program: boot-05-web-admin
 * @description:
 * @author: ly
 * @create: 2021-11-25 14:06
 **/
@Controller
public class IndexController {
    @Autowired
    UserService userService;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    AccountService accountService;
    @Autowired
    CityService cityService;
    @PostMapping("/city")
    public City saveCity(City city){
        cityService.saveCity(city);
        return city;
    }
    @ResponseBody
    @GetMapping("/city")
    public City getCityById(@RequestParam("id") Long id){
     return cityService.getById(id);
    }


    @ResponseBody
    @GetMapping("/acct")
    public Account getById(@RequestParam("id") Long id){

        return accountService.getAcctById(id);

    }
    @ResponseBody
    @GetMapping("/sql")
    public String queryFormDb(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from tb_user", Long.class);
        return aLong.toString();
    }
    /**
     * 来登录页
     * @return
     */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){
    return "login";
    }
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        if (StringUtils.hasLength(user.getUsername())&&"123456".equals(user.getPassword())){
            //把登录成功的用户保存起来
         session.setAttribute("loginUser",user);
        //登录成功，重定向到main页面，重定向防止表单重复提交
        return "redirect:/main.html";
        }else {
            model.addAttribute("msg","账号密码错误");
            //回到登录页面
            return "login";
        }

    }

    /**
     * 去main页面
     * @return
     */
    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser!=null){
            return "main";
        } else {
            //回到登录页
            model.addAttribute("msg","请重新登录");
            return "login";
        }

    }
}
