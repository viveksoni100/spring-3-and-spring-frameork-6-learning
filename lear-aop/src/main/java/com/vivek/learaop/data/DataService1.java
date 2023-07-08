package com.vivek.learaop.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService1 {

    public int[] retrieveData() {
        return new int[]{10, 20, 30};
    }
}
