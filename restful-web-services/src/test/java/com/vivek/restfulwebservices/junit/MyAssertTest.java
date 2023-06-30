package com.vivek.restfulwebservices.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class MyAssertTest {

    List<String> todos = Arrays.asList("AWS", "Azure", "DevOps");

    @Test
    void test() {
        boolean test = todos.contains("AWS");
        assertTrue(test);
//        assertFalse();
//        assertNull();
//        assertNotNull();
        assertArrayEquals(new int[]{1,2}, new int[]{1,2});

    }
}
