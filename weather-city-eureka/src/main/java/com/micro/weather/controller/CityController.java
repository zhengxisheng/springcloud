package com.micro.weather.controller;

import com.micro.weather.service.CityDataService;
import com.micro.weather.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zhengxisheng on 2018/7/10.
 *
 * 获取城市列表接口
 */
@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityDataService cityDataService;

    @GetMapping
    public List<City> listCity() throws Exception{
        return  cityDataService.listCity();
    }
}
