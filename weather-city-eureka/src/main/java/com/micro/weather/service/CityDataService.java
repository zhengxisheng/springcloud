package com.micro.weather.service;

import com.micro.weather.vo.City;

import java.util.List;

/**
 * Created by zhengxisheng on 2018/7/10.
 *
 * City Data Service
 */
public interface CityDataService {

    /**
     * 获取城市列表接口
     * @return
     * @throws Exception
     */
    List<City> listCity() throws Exception;
}
