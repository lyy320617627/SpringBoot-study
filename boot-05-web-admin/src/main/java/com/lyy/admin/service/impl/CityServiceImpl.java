package com.lyy.admin.service.impl;

import com.lyy.admin.bean.City;
import com.lyy.admin.mapper.CityMapper;
import com.lyy.admin.service.CityService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: boot-05-web-admin
 * @description:
 * @author: ly
 * @create: 2021-11-27 18:24
 **/
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityMapper cityMapper;
    Counter counter;
    public CityServiceImpl(MeterRegistry meterRegistry){
         counter = meterRegistry.counter("cityService.saveCity.count");

    }
    public City getById(Long id){
        return  cityMapper.getById(id);
    }

    public void saveCity(City city) {
        counter.increment();
        cityMapper.insert(city);
    }
}
