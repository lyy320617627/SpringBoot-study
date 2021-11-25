package com.lyy.admin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: boot-05-web-admin
 * @description:
 * @author: ly
 * @create: 2021-11-25 14:41
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private String username;
    private String password;

}
