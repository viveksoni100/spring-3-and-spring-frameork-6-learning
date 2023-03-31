package com.example.learspring.helloworld;

import lombok.Data;

@Data
public class Address {

    private String firstLine;
    private String city;

    public Address(String firstLine, String city) {
        this.firstLine = firstLine;
        this.city = city;
    }
}
