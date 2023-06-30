package com.vivek.restfulwebservices.mockito;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SomeBusinessImplMockTest {

    @Test
    void findTheGreatestFromAllData_basicScenario() {
        DataServiceStub dataserviceMock = mock(DataServiceStub.class);
        when(dataserviceMock.retrieveAllData())
                .thenReturn(new int[]{1,2,3});
//        DataServiceStub serviceStub = new DataServiceStub();
        SomeBusinessImpl business = new SomeBusinessImpl(dataserviceMock);

        assertEquals(3, business.findTheGreatestFromAllData());
    }

    @Test
    void findTheGreatestFromAllData_oneValueScenario() {
        DataServiceStub dataserviceMock = mock(DataServiceStub.class);
        when(dataserviceMock.retrieveAllData())
                .thenReturn(new int[]{25});
//        DataServiceStub serviceStub = new DataServiceStub();
        SomeBusinessImpl business = new SomeBusinessImpl(dataserviceMock);

        assertEquals(25, business.findTheGreatestFromAllData());
    }
}
