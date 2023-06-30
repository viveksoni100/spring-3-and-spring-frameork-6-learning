package com.vivek.restfulwebservices.mockito;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SomeBusinessImplStubTest {

    @Test
    void findTheGreatestFromAllData_basicScenario() {
        DataServiceStub serviceStub = new DataServiceStub();
        SomeBusinessImpl business = new SomeBusinessImpl(serviceStub);

        assertEquals(3, business.findTheGreatestFromAllData());
    }
}

class DataServiceStub implements DataService {

    @Override
    public int[] retrieveAllData() {
        return new int[]{1, 2, 3};
    }
}
