package com.example.learspring.preconstruct.postdestroy;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class SomeDependency {

    public void getReady() {
        System.out.println("some logic using some dependency");
    }
}

@Component
class SomeClass {
    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency) {
        this.someDependency = someDependency;
        System.out.println("all dependency are ready");
    }

    @PostConstruct  //@PostConstruct is a Java annotation that is used to annotate a method that needs to be executed
                    // after dependency injection is done to perform any initialization tasks.
    public void initialize() {
        someDependency.getReady();
    }

    @PreDestroy //@PreDestroy is a Java annotation used to indicate a method to be called before a bean is removed from
                // the container. It is used to perform any cleanup or releasing of resources held by the bean before it is destroyed.
    public void cleanUp () {
        System.out.println("close all database connections");
    }
}

@Configuration
@ComponentScan
public class PreConstructAndPostDestroyLauncherApplication {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(PreConstructAndPostDestroyLauncherApplication.class)) {
            System.out.println(context.getBean(SomeClass.class));
        } catch (NoSuchBeanDefinitionException e) {
            e.printStackTrace();
        }
    }

}
