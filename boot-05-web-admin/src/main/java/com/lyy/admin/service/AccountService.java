package com.lyy.admin.service;

import com.lyy.admin.bean.Account;
import com.lyy.admin.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: boot-05-web-admin
 * @description:
 * @author: ly
 * @create: 2021-11-27 17:53
 **/

@Service
public class AccountService {
    @Autowired
    AccountMapper accountMapper;

    public Account getAcctById(Long id){
       return  accountMapper.getAcct(id);

    }
}
