package com.example.springboot_rest_jpa_postgres.dto;

import lombok.Data;

@Data
public class CityDto {

    private Integer id;
    private String cityName;
    private String cityCode;
    private Integer countryId;

}
