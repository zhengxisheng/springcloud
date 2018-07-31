package com.micro.weather.service;

import com.micro.weather.vo.City;
import com.micro.weather.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by zhengxisheng on 2018/7/12.
 *
 * 微服务统一访问入口
 */
@FeignClient("weather-eureka-client-zuul")
public interface DataClient {


    /**
     *  获取城市列表
     * @return
     * @throws Exception
     */
    @GetMapping("/city/cities")
    List<City> listCity() throws Exception;

    /**
     *  根据城市ID查询天气信息
     * @param cityId
     * @return
     */
    @GetMapping("/data/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId")String cityId);
}
