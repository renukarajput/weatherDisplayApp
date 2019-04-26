package com.ren.weather.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "CityTemp")
@Entity
public class CityTemp {

    @GeneratedValue
    Long id;

    @Id
    @Column(name = "Name")
    @NotNull
    private String name;

    @Column(name = "Temperature")
    private Integer temperature;

    public CityTemp(@NotNull String name, Integer temperature) {
        this.name = name;
        this.temperature = temperature;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

