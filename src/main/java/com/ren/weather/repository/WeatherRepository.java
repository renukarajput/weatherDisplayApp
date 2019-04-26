package com.ren.weather.repository;

import com.ren.weather.entity.CityTemperature;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface WeatherRepository extends CrudRepository<CityTemperature, String> {
    List<CityTemperature> findByNameLike(String prefix);
}
