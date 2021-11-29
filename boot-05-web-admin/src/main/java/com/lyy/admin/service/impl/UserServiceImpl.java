package com.lyy.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyy.admin.bean.User;
import com.lyy.admin.mapper.UserMapper;
import com.lyy.admin.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @program: boot-05-web-admin
 * @description:
 * @author: ly
 * @create: 2021-11-27 19:58
 **/

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


}
