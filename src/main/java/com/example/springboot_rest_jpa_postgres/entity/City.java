package com.example.springboot_rest_jpa_postgres.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity(name = "cities")
public class City {

//    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cityName;

    @Column(name = "city_code",columnDefinition = "character varying(6) not null default 'NA'")
    private String cityCode;

    @ManyToOne
    private Country country;

//    @Transient
//    private String beanId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        City city = (City) o;

        return Objects.equals(id, city.id);
    }

    @Override
    public int hashCode() {
        return 39525063;
    }
}
