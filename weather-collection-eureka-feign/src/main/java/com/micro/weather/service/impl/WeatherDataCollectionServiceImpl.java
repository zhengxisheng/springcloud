package com.micro.weather.service.impl;

import com.micro.weather.service.WeatherDataCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * Weather Data Collection Service
 * <p>
 * Created by zhengxisheng on 2018/7/9.
 */
@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {

    //获取天气数据外部请求路径
    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
    //redis超时时间
    private static final long TIME_OUT = 1800L;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void synDateByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        this.saveWeatherData(uri);
    }
    private void  saveWeatherData(String uri){
        ValueOperations<String,String> ops = stringRedisTemplate.opsForValue();
        //调用服务接口获取天气数据
        ResponseEntity<String> rspString = restTemplate.getForEntity(uri, String.class);
        //写入redis缓存
        if (rspString.getStatusCodeValue() == 200){
            ops.set(uri,rspString.getBody(),TIME_OUT, TimeUnit.SECONDS);
        }
    }
}
