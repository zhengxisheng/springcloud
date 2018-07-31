package com.micro.weather.vo;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by zhengxisheng on 2018/7/10.
 *
 * CityList entity
 */
@XmlRootElement(name = "c")
@XmlAccessorType(XmlAccessType.FIELD)
public class CityList {

    @XmlElement(name = "d")
    private List<City> cityList;

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
}
