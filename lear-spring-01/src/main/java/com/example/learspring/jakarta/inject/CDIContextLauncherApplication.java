package com.example.learspring.jakarta.inject;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Component
@Named  // just like component in jakarta CDI
class BusinessService {

    private DataService dataService;

    public DataService getDataService() {
        return dataService;
    }
    //@Autowired
    @Inject // just like autowire in jakarta CDI
    public void setDataService(DataService dataService) {
        System.out.println("setter injection would performed");
        this.dataService = dataService;
    }
}

//@Component
@Named
class DataService {

}

@Configuration
@ComponentScan
public class CDIContextLauncherApplication {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(CDIContextLauncherApplication.class)) {
            // Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean(BusinessService.class).getDataService());
        } catch (NoSuchBeanDefinitionException e) {
            e.printStackTrace();
        }
    }

}
