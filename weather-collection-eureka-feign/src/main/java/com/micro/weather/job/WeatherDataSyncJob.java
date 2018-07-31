package com.micro.weather.job;

import com.micro.weather.service.CityClient;
import com.micro.weather.service.WeatherDataCollectionService;
import com.micro.weather.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * Created by zhengxisheng on 2018/7/9.
 * <p>
 * quartz sync weather data
 */
public class WeatherDataSyncJob extends QuartzJobBean {

    private final static Logger log = LoggerFactory.getLogger(WeatherDataSyncJob.class);

    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;

    @Autowired
    private CityClient cityClient;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("Weather Data Sync Job..Start!");
        List<City> cityList;
        try {
            //城市微服务提供数据
            cityList = cityClient.listCity();
        } catch (Exception e) {
            log.error("get city list error", e);
            return;
        }
        for (City city : cityList) {
            log.info("Weather Data Sync Job..cityId:{}", city.getCityId());
            weatherDataCollectionService.synDateByCityId(city.getCityId());
        }
        log.info("Weather Data Sync Job..end!");
    }
}
