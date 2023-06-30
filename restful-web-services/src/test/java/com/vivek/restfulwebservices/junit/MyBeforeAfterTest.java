package com.vivek.restfulwebservices.junit;

import org.junit.jupiter.api.*;

public class MyBeforeAfterTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("before all");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("before each");
    }

    @Test
    void test_1() {
        System.out.println("test 1");
    }

    @Test
    void test_2() {
        System.out.println("test 2");
    }

    @Test
    void test_3() {
        System.out.println("test 3");
    }

    @AfterEach
    void afterEach() {
        System.out.println("after each");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after all");
    }
}
