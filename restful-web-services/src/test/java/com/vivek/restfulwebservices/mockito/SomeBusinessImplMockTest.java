package com.vivek.restfulwebservices.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // without this annotation mocks ill give nullPointer
public class SomeBusinessImplMockTest {

    @Mock
    private DataService dataServiceMock;

    @InjectMocks
    private SomeBusinessImpl someBusiness;

    @Test
    void findTheGreatestFromAllData_basicScenario() {
        when(dataServiceMock.retrieveAllData())
                .thenReturn(new int[]{1,2,3});

        assertEquals(3, someBusiness.findTheGreatestFromAllData());
    }

    /**
     * without mockito annotations
     */
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
