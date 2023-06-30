package com.vivek.restfulwebservices.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyMathTest {

    @Test
    void calculateSum_ThreeMemberArray() {
        MyMath math = new MyMath();
        int result = math.calculateSum(new int[]{1,2,3});

        assertEquals(6, result);
    }
}
