package com.example.learspring.exc.business.calculation.service;

import org.springframework.stereotype.Component;

@Component
public class MySQLDbDataService implements DataService {
    @Override
    public int[] retrieveData() {
        return new int[] {4,5,6};
    }
}
