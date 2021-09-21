package com.example.springboot_rest_jpa_postgres.service;

import com.example.springboot_rest_jpa_postgres.dto.CityDto;
import com.example.springboot_rest_jpa_postgres.entity.City;
import com.example.springboot_rest_jpa_postgres.entity.Country;
import com.example.springboot_rest_jpa_postgres.repo.CityRepo;
import com.example.springboot_rest_jpa_postgres.repo.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    private CityRepo cityRepo;
    private CountryRepo countryRepo;

    @Autowired
    public CityService(CityRepo cityRepo, CountryRepo countryRepo) {
        this.cityRepo = cityRepo;
        this.countryRepo = countryRepo;
    }

    public List<City> getCities() {
        try {
            List<City> all = cityRepo.findAll();
            return all;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public City saveCity(City city) {
        try {
            return cityRepo.save(city);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public City getCity(String cityName) {
        try {
            return cityRepo.findByCityName(cityName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public City saveC(CityDto cityDto) {
        Optional<Country> byId = countryRepo.findById(cityDto.getCountryId());

        City city = new City();
        city.setCityName(cityDto.getCityName());
        city.setCityCode(cityDto.getCityCode());
        city.setCountry(byId.get());

        return cityRepo.save(city);

    }

    public Country getCountry(int id) {

        return countryRepo.getById(id);

    }

    public List<Country> getCountryByName(String prefix) {

        return countryRepo.getByCountryname(prefix);
    }

    public List<Object[]> getCountryByNameAndPop(String prefix, long population) {
        return countryRepo.getByCnameAAndPopulation(prefix,population);
    }
}
