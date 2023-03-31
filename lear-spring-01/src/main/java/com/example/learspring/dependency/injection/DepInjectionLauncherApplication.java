package com.example.learspring.dependency.injection;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Configuration
@ComponentScan("com.example.learspring.dependency.injection")
public class DepInjectionLauncherApplication {

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(item -> System.out.println(item));
            System.out.println("===================================================================");
            System.out.println(context.getBean(YourBusinessClass.class));
        } catch (NoSuchBeanDefinitionException e) {
            e.printStackTrace();
        }
    }

}

@Component
class YourBusinessClass {

    @Autowired
    Dependency1 dependency1;
    @Autowired
    Dependency2 dependency2;

    @Override
    public String toString() {
        return "YourBusinessClass{" +
                "dependency1=" + dependency1 +
                ", dependency2=" + dependency2 +
                '}';
    }
}

@Component
class Dependency1 {

}

@Component
class Dependency2 {

}
