package com.example.learspring.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * we can define more than one beans in this class
 */

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name() {
        return "Vivek";
    }

    @Bean
    public int age() {
        return 28;
    }

    @Bean
    @Primary // it can be applied to a bean declaration to indicate that it should be preferred
            // when multiple beans of the same type are present
    public Person person() {
        var person = new Person("Sun", 20, new Address("Gundavadi", "Rajkot"));
        return person;
    }

    @Bean
    public Person person2MethodCall() {
        var person = new Person(name(), age(), address());
        return person;
    }

    @Bean(name = "addressRenamed")
    @Qualifier("addressQualifier")
    public Address address() {
        return new Address("Baker Street", "London");
    }

    @Bean
    public Person person3Parameters(String name, int age, Address addressRenamed) {
        var person = new Person(name, age, addressRenamed);
        return person;
    }

}