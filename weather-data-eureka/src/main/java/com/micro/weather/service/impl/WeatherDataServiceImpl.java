package com.micro.weather.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.micro.weather.service.WeatherDataService;
import com.micro.weather.vo.WeatherResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by zhengxisheng on 2018/7/10.
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private static final Logger log = LoggerFactory.getLogger(WeatherDataServiceImpl.class);

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        return this.doGetWeather(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "city=" + cityName;
        return this.doGetWeather(uri);
    }

    private WeatherResponse doGetWeather(String uri) {
        ObjectMapper mapper = new ObjectMapper();
        String strBody = StringUtils.EMPTY;
        WeatherResponse rsp = null;
        String key = uri;
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        if (stringRedisTemplate.hasKey(key)) {
            strBody = ops.get(uri);
        } else {
            log.error("Redis don't has data,key:{}", uri);
        }
        try {
            rsp = mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            log.error("string to object convert error", e);
        }
        return rsp;
    }
}
