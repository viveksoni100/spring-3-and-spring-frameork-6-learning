package com.example.learspring.exc.business.calculation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan("com.example.learspring.exc.business.calculation.service")
public class BusinessCalculationService {

    DataService dataService;

    @Autowired
    public BusinessCalculationService(@Qualifier("mySQLDbDataService") DataService dataService) {
        this.dataService = dataService;
    }

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(BusinessCalculationService.class)) {
            System.out.println(context.getBean(BusinessCalculationService.class).findMax());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int findMax() {
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }

}
