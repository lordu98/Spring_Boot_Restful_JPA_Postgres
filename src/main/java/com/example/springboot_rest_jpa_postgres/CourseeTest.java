package com.example.springboot_rest_jpa_postgres;

import java.util.HashSet;
import java.util.Set;

public class CourseeTest {
    private String name;
    private Set<ContentTest> contents=new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ContentTest> getContents() {
        return contents;
    }

    public void setContents(Set<ContentTest> contents) {
        this.contents = contents;
    }
}
