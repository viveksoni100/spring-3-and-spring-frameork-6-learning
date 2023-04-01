package com.example.learspring.lazy.initialization;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class classA {

}

@Component
@Lazy   // In the Spring Framework, the @Lazy annotation is used to indicate that a bean should be lazily initialized.
        // This means that the bean will not be instantiated and initialized until it is actually needed,
        // rather than at the time of application startup.
class classB {
    private classA classA;

    /**
     * constructor autowiring is used, no need to explicitly write @Autowire on constructor
     *
     * @param classA
     */
    public classB(classA classA) {
        System.out.println("some initialization logic");
        this.classA = classA;
    }
}

@Configuration
@ComponentScan
public class LaziInitLauncherApplication {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(LaziInitLauncherApplication.class)) {
            // classB classB = new classB(new classA()); // uncommenting this line will print 'some initialization logic in the console'
            context.getBean(classB.class);
        } catch (
                NoSuchBeanDefinitionException e) {
            e.printStackTrace();
        }
    }
}
