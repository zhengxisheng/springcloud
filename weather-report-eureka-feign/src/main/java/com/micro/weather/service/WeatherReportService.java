package com.micro.weather.service;

import com.micro.weather.vo.Weather;

/**
 * Created by zhengxisheng on 2018/7/11.
 */
public interface WeatherReportService {

    /**
     * 根据城市ID查询天气信息
     * @param cityId
     * @return
     */
    Weather getDataByCityId(String cityId);
}
