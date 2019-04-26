package com.ren.weather.dto;

import com.ren.weather.entity.CityTemperature;

import java.util.List;

public class CityTempDTO {
    String msg;
    List<CityTemperature> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<CityTemperature> getData() {
        return data;
    }

    public void setData(List<CityTemperature> data) {
        this.data = data;
    }
}
