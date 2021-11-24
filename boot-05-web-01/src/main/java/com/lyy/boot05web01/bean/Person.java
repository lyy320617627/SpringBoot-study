package com.lyy.boot05web01.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @program: boot-05-web-01
 * @description:
 * @author: ly
 * @create: 2021-11-24 09:48
 **/
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {

    private String userName;
    private Integer age;
    private Date birth;
    private Pet pet;

}
