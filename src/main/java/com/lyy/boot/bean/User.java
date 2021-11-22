package com.lyy.boot.bean;

import lombok.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @program: boot-1-helloworld
 * @description:
 * @author: ly
 * @create: 2021-11-22 14:22
 **/
@ToString
//@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class User {
    private String name;
    private Integer age;
     private Pet pet;
   public User(String name, Integer age){
       this.name=name;
       this.age=age;
   }
}
