package com.ren.weather.service;

import com.ren.weather.entity.CityTemp;
import com.ren.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Component
@Service
public class WeatherService {
    @Autowired
    private WeatherRepository weatherRepository;

    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public String testInsert(String cityName) {
        CityTemp city = new CityTemp(cityName, 40);

        this.weatherRepository.save(city);
        System.out.println("city insert operation #####");
        return  "Inserted: " + city;
    }

    @RequestMapping("/find")
    public List<CityTemp> findAll() {
        return (List<CityTemp>) this.weatherRepository.findAll();
    }
}
