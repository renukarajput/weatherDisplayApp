package com.ren.weather.repository;

import com.ren.weather.entity.CityTemp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface WeatherRepository extends CrudRepository<CityTemp, String> {
    List<CityTemp> findByPrefixLike(String prefix);
    String findByCity(String city);
}
