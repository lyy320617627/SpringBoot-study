package com.lyy.admin.service;

import com.lyy.admin.bean.City;
import com.lyy.admin.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: boot-05-web-admin
 * @description:
 * @author: ly
 * @create: 2021-11-27 18:24
 **/
@Service
public class CityService {
    @Autowired
    CityMapper cityMapper;
    public City getById(Long id){
        return  cityMapper.getById(id);
    }

    public void saveCity(City city) {
        cityMapper.insert(city);
    }
}
