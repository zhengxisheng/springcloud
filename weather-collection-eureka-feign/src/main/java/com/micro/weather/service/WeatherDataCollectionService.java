package com.micro.weather.service;

/**
 * Created by zhengxisheng on 2018/7/9.
 *
 * Weather Data Collection Service
 */
public interface WeatherDataCollectionService {

    /**
     * 根据城市ID同步天气
     * @param cityId
     */
    void synDateByCityId(String cityId);
}


