package com.vivek.learaop.aopexample;

import com.vivek.learaop.annotations.TrackTime;
import com.vivek.learaop.data.DataService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService1 {

    @Autowired
    private DataService1 dataService1;

    @TrackTime
    public int calculateMax() {
        int[] data = dataService1.retrieveData();
//        throw new RuntimeException("Locha padi gya!");
        return Arrays.stream(data).max().orElse(0);
    }
}
