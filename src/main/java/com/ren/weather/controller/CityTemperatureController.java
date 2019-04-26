package com.ren.weather.controller;

import com.ren.weather.dto.CityTempDTO;
import com.ren.weather.dto.CityTemperatureErrorDTO;
import com.ren.weather.entity.CityTemperature;
import com.ren.weather.exceptions.CityTemperatureException;
import com.ren.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/city/")
public class CityTemperatureController {
// example.com/get_temp_ajax?name_prefix=kol

    @Autowired
    private WeatherService weatherService;

    @GetMapping("test")
    public String test() {
        return "up";
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody CityTemperature cityTemp) {
        weatherService.add(cityTemp);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    private ResponseEntity<CityTempDTO> getCityTempDTOResponseEntity(List<CityTemperature> cityTempList) {
        CityTempDTO cityTempDTO = new CityTempDTO();
        cityTempDTO.setData(cityTempList);
        cityTempDTO.setMsg("success");
        return ResponseEntity.ok(cityTempDTO);
    }

    @GetMapping
    public ResponseEntity<CityTempDTO> getByPrefix(@RequestParam String prefix) {
        List<CityTemperature> cityTempList = weatherService.findByPrefix(prefix);
        return getCityTempDTOResponseEntity(cityTempList);
    }

    @GetMapping("{cityName}")
    ResponseEntity<CityTempDTO> getByCity(@PathVariable String cityName) {
        CityTemperature cityTemperature = weatherService.findByCity(cityName);
        return getCityTempDTOResponseEntity(Arrays.asList(cityTemperature));
    }

    @ExceptionHandler
    ResponseEntity<CityTemperatureErrorDTO> handleException(CityTemperatureException e){
        CityTemperatureErrorDTO cityTemperatureErrorDTO = new CityTemperatureErrorDTO();
        cityTemperatureErrorDTO.setStatus("error");
        cityTemperatureErrorDTO.setErrorMessage(e.getErrorMessage());
        return ResponseEntity.status(e.getHttpStatus()).body(cityTemperatureErrorDTO);
    }
}
