package com.lyy.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
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
    /**
     * 所有属性都应该在数据库中中
     */
    @TableField(exist = false)
    private String username;
    @TableField(exist = false) //表示当前数据在数据库中不存在
    private String password;
    //以下是数据库的字段
        private Long id;
        private String name;
        private Integer age;
        private String email;
}
