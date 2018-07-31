package com.micro.weather.service.impl;

import com.micro.weather.service.WeatherDataClient;
import com.micro.weather.service.WeatherReportService;
import com.micro.weather.vo.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhengxisheng on 2018/7/11.
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private WeatherDataClient weatherDataClient;

    @Override
    public Weather getDataByCityId(String cityId) {
        return weatherDataClient.getDataByCityId(cityId).getData();
    }
}
