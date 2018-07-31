package com.micro.weather.controller;

import com.micro.weather.service.DataClient;
import com.micro.weather.vo.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by zhengxisheng on 2018/7/11.
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {

    private static final Logger log = LoggerFactory.getLogger(WeatherReportController.class);

//    @Autowired
//    private WeatherReportService weatherReportService;
//
//    @Autowired
//    private CityClient cityClient;

    @Autowired
    private DataClient dataClient;

    @Value("${neo.hello}")
    private String hello;

    //    /**
//     *  根据城市Id获取天气信息(没有引入网关方式)
//     * @param cityId
//     * @param model
//     * @return
//     */
//    @GetMapping("/cityId/{cityId}")
//    public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) {
//        List<City> cityList = null;
//        try {
//            //城市微服务获取城市列表
//            cityList = cityClient.listCity();
//        } catch (Exception e) {
//            log.error("get citylist error", e);
//        }
//        model.addAttribute("cityId", cityId);
//        //城市数据微服务获取天气信息
//        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
//        model.addAttribute("cityList", cityList);
//        return new ModelAndView("/weather/report","reportModel",model);
//    }

    /**
     *  根据城市Id获取天气信息(网关方式)
     * @param cityId
     * @param model
     * @return
     */
    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) {
        List<City> cityList = null;
        try {
            //城市微服务获取城市列表
            cityList = dataClient.listCity();
        } catch (Exception e) {
            log.error("get citylist error", e);
        }
        model.addAttribute("cityId", cityId);
        //城市数据微服务获取天气信息
        model.addAttribute("report", dataClient.getDataByCityId(cityId).getData());
        model.addAttribute("cityList", cityList);
        return new ModelAndView("/weather/report", "reportModel", model);
    }

    @RequestMapping("/hello")
    public String getConfigInfo(){
        return this.hello;
    }

}
