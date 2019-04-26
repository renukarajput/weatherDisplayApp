package com.ren.weather.service;

import com.ren.weather.entity.CityTemperature;
import com.ren.weather.exceptions.CityTemperatureException;
import com.ren.weather.repository.WeatherRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import javax.annotation.Resource;
import java.util.List;

@Component
@Service
public class WeatherService {
    @Resource
    private WeatherRepository weatherRepository;

    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public void add( CityTemperature cityTemp) {
        if (cityTemp != null)
            this.weatherRepository.save(cityTemp);
    }

    public CityTemperature findByCity(String city) {
        return weatherRepository.findById(city).orElseThrow(() ->
                new CityTemperatureException(HttpStatus.NOT_FOUND, "Resource Not Found"));
    }

    public List<CityTemperature> findByPrefix(String prefix) {
        if (StringUtils.isEmpty(prefix) || prefix.length() < 3) {
                throw new CityTemperatureException(HttpStatus.BAD_REQUEST, "Too few characters");
        }
        String pattern = prefix.concat("%");
        return weatherRepository.findByNameLike(pattern);
    }
}
