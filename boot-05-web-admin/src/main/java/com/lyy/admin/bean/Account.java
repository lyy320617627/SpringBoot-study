package com.lyy.admin.bean;

import lombok.Data;

/**
 * @program: boot-05-web-admin
 * @description:
 * @author: ly
 * @create: 2021-11-27 15:24
 **/
@Data
public class Account {
   private Long id;
   private String user_name;
   private String password;
   private int age;
   private String email;
}