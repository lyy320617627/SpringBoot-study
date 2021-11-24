package com.lyy.boot05web01.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @program: boot-05-web-01
 * @description:
 * @author: ly
 * @create: 2021-11-24 09:49
 **/
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pet {
    private String name;
    private Integer age;
}
