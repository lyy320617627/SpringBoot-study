package com.lyy.admin.mapper;

import com.lyy.admin.bean.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {

    public Account getAcct(Long id);

}
