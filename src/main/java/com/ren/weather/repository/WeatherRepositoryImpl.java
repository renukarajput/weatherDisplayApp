package com.ren.weather.repository;

import com.ren.weather.entity.CityTemp;

import java.util.List;
import java.util.Optional;

public class WeatherRepositoryImpl implements WeatherRepository {
    @Override
    public List<CityTemp> findByPrefixLike(String prefix) {
        return null;
    }

    @Override
    public String findByCity(String city) {
        return "Pune";
    }

    @Override
    public <S extends CityTemp> S save(S entity) {
        return null;
    }

    @Override
    public <S extends CityTemp> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<CityTemp> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public Iterable<CityTemp> findAll() {
        return null;
    }

    @Override
    public Iterable<CityTemp> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(CityTemp entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends CityTemp> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
