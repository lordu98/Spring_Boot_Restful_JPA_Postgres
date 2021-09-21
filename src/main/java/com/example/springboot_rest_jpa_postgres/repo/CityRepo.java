package com.example.springboot_rest_jpa_postgres.repo;

import com.example.springboot_rest_jpa_postgres.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepo extends JpaRepository<City,Long> {

    City findByCityName(String cityName);

}
