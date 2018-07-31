package com.micro.weather.service;

import com.micro.weather.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by zhengxisheng on 2018/7/9.
 *
 * city client
 */
@FeignClient("weather-city-eureka")
public interface CityClient {

    @GetMapping("/cities")
    List<City> listCity() throws Exception;
}
