package com.example.springboot_rest_jpa_postgres.repo;

import com.example.springboot_rest_jpa_postgres.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryRepo extends JpaRepository<Country, Integer> {

    Country findById(int id);

    @Query("from countries where id =?1")
    Country getById(int id);

    List<Country> findByCountryNameStartsWithOrderByPopulationAsc(String prefix);

    @Query("select c from countries c where c.countryName like ?1% order by c.population asc")
    List<Country> getByCountryname(String prefix);

//    @Query("select c from countries c where c.countryName like :cname% and c.population >= :population")
//    List<Country> getByCnameAAndPopulation(@Param("cname") String cname,@Param("population") long population); //@Param readble
//
     @Query("select c.countryName, c.population from countries c where c.countryName like :cname% and c.population >= :population")
    List<Object[]> getByCnameAAndPopulation(@Param("cname") String cname,@Param("population") long population); //@Param readble

     @Query(value="select c.countryName, c.population from countries c where c.countryName like :cname% and c.population >= :population",nativeQuery = true)
    List<Object[]> getByCnameAAndPopulationNative(@Param("cname") String cname,@Param("population") long population); //@Param readble
}
