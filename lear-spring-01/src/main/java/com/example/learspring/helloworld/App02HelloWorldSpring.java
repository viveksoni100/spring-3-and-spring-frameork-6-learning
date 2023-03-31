package com.example.learspring.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * iteration-2 provided loose coupling using interfaces
 */

public class App02HelloWorldSpring {


    public static void main(String[] args) {

        //1 launch a spring context
        try (var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
            //2 configure the things that we want spring to manage - by HelloWorldConfiguration class using @Configuration

            //3 retrieving beans managed by spring
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("person"));

            System.out.println(context.getBean("addressRenamed")); // two ways of retrieving bean
            System.out.println(context.getBean(Address.class));

            System.out.println(context.getBean("person2MethodCall"));

            System.out.println(context.getBean("person3Parameters"));

            System.out.println(context.getBean(Person.class));

            System.out.println("================= listing all beans present in the context ==================");
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
