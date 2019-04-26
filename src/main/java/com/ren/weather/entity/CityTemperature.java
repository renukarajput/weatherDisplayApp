package com.ren.weather.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "CityTemp")
@Entity
public class CityTemperature {

    @Id
    @Column(name = "Name")
    @NotNull
    private String name;

    @Column(name = "Temperature")
    private Integer temperature;

    public CityTemperature(){

    }
    public CityTemperature(@NotNull String name, Integer temperature) {
        this.name = name;
        this.temperature = temperature;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

