package com.example.springboot_rest_jpa_postgres.controller;

import com.example.springboot_rest_jpa_postgres.dto.CityDto;
import com.example.springboot_rest_jpa_postgres.dto.CourseDto;
import com.example.springboot_rest_jpa_postgres.entity.City;
import com.example.springboot_rest_jpa_postgres.entity.Country;
import com.example.springboot_rest_jpa_postgres.entity.Course;
import com.example.springboot_rest_jpa_postgres.service.CityService;
import com.example.springboot_rest_jpa_postgres.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/home")
public class HomeController {

    CityService cityService;
    CourseService courseService;

    @Autowired
    public HomeController(CityService cityService, CourseService courseService) {
        this.cityService = cityService;
        this.courseService = courseService;
    }

    @GetMapping("")
    public ResponseEntity<?> sayHello() {
        return ResponseEntity.ok("Assalomu aleykum");
    }

    @GetMapping("getCities")
    public ResponseEntity<?> getCities() {
        List<City> cities = cityService.getCities();
        return ResponseEntity.status(cities.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK).body(cities);
    }

    @PostMapping("addCity")
    public ResponseEntity<City> saveCity(@RequestBody City city) {
        City savedCity = cityService.saveCity(city);
        return ResponseEntity.status(savedCity == null ? HttpStatus.NO_CONTENT : HttpStatus.CREATED).body(savedCity);
    }

    @GetMapping("getCity/{cityName}")
    public ResponseEntity<City> getCity(@PathVariable String cityName) {
        City city = cityService.getCity(cityName);
        return ResponseEntity.status(city == null ? HttpStatus.NOT_FOUND : HttpStatus.FOUND).body(city);
    }

    @PostMapping("saveCity")
    public ResponseEntity<City> save(@RequestBody CityDto cityDto) {
        City savedCity = cityService.saveC(cityDto);
        return ResponseEntity.status(savedCity == null ? HttpStatus.NO_CONTENT : HttpStatus.CREATED).body(savedCity);
    }

    @PostMapping("addCourse")
    public ResponseEntity<?> addCourse(@RequestBody CourseDto courseDto) {
        Course courseDto1 = courseService.addCourseWithContents(courseDto);
        return ResponseEntity.status(courseDto1 == null ? HttpStatus.NO_CONTENT : HttpStatus.CREATED).body(courseDto1);
    }

    @GetMapping("getCountry")
    public ResponseEntity<?> getCountry(@RequestParam int id) {
        System.out.println(id);
        Country country= cityService.getCountry(id);
        return ResponseEntity.status(country == null ? HttpStatus.NO_CONTENT : HttpStatus.FOUND).body(country);
    }

    @GetMapping("getCountryByName")
    public ResponseEntity<?> getCountryByName(@RequestParam String prefix) {
        System.out.println(prefix);
        List<Country> country= cityService.getCountryByName(prefix);
        return ResponseEntity.status(country == null ? HttpStatus.NO_CONTENT : HttpStatus.FOUND).body(country);
    }

    @GetMapping("getCountryByNameAndPop")
    public ResponseEntity<?> getCountryByNameAndPop(@RequestParam String prefix,
                                                    @RequestParam long population) {
        System.out.println(prefix);
        System.out.println(population);
        List<Object[]> country= cityService.getCountryByNameAndPop(prefix,population);
        return ResponseEntity.status(country == null ? HttpStatus.NO_CONTENT : HttpStatus.FOUND).body(country);
    }

}
