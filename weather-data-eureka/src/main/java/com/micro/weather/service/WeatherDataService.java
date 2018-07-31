package com.micro.weather.service;

import com.micro.weather.vo.WeatherResponse;

/**
 * Created by zhengxisheng on 2018/7/10.
 */
public interface WeatherDataService {

    /**
     * 根据城市Id查询天气数据
     * @param cityId
     * @return
     */
    WeatherResponse getDataByCityId(String cityId);

    /**
     * 根据城市名称查询天气数据
     * @param cityName
     * @return
     */
    WeatherResponse getDataByCityName(String cityName);
}
