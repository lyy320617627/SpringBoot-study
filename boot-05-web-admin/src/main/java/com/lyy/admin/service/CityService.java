package com.lyy.admin.service;

import com.lyy.admin.bean.City;

public interface CityService {

    City getById(Long id);

    void saveCity(City city);
}
