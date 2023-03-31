package com.example.learspring.spring.game;

import com.example.learspring.game.GameRunner;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.learspring.game")
public class App03GamingBasic {

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(App03GamingBasic.class)) {
            context.getBean(GameRunner.class).run();
        } catch (NoSuchBeanDefinitionException e) {
            e.printStackTrace();
        }
    }

}
