package com.lyy.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @program: boot-1-helloworld
 * @description:
 * @author: ly
 * @create: 2021-11-22 14:20
 **/
@Data
@ToString
@NoArgsConstructor  //无参构造器
@AllArgsConstructor//全参构造器
public class Pet {

    private String name;

}
