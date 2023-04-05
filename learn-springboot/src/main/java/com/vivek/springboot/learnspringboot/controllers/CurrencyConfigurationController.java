package com.vivek.springboot.learnspringboot.controllers;

import com.vivek.springboot.learnspringboot.configuration.CurrencyServiceConfiguration;
import com.vivek.springboot.learnspringboot.dto.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CurrencyConfigurationController {

    @Autowired
    private CurrencyServiceConfiguration configuration;

    @RequestMapping("/currency-configuration")
    public CurrencyServiceConfiguration retrieveAllCurrencies() {
        return configuration;
    }

}
