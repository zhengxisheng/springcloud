package com.micro.weather.vo;

/**
 * Created by zhengxisheng on 2018/7/10.
 */
public class WeatherResponse {

    private Weather data;

    private Integer status;

    private String desc;

    public Weather getData() {
        return data;
    }

    public void setData(Weather data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
