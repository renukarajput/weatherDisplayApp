package com.ren.weather.controller;

import com.ren.weather.entity.CityTemp;
import com.ren.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class WeatherController {
// example.com/get_temp_ajax?name_prefix=kol

    @Autowired
    private WeatherService weatherService;

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @GetMapping("/allCities")
    public List<CityTemp> getAllCities() {
        return weatherService.findAll();
    }

//    @GetMapping("/city")
//    @ResponseBody
    @RequestMapping("/city")
    ResponseEntity<String> getByCity(@RequestParam String city) {
        weatherService.testInsert(city);
        return ResponseEntity.ok().body("Inserted city: " + city);
    }
}
