package com.vivek.restfulwebservices.mockito;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    void simple_Test() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(3);

        assertEquals(3, listMock.size());
    }

    @Test
    void multiple_Returns() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(3).thenReturn(4);

        assertEquals(3, listMock.size());
        assertEquals(4, listMock.size());
    }

    @Test
    void generic_parameters() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(3).thenReturn(4);

        assertEquals(3, listMock.size());
        assertEquals(4, listMock.size());
    }
}
