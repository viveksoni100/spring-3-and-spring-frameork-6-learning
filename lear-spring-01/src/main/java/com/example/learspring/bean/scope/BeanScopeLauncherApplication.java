package com.example.learspring.bean.scope;

import com.example.learspring.spring.game.App03GamingBasic;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
class NormalClass {

}

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component  //In Spring Framework, the @Scope annotation is used to specify the scope of a bean, which determines the
            // lifecycle and visibility of the bean in the application context.
class PrototypeClass {

}

@Configuration
@ComponentScan
public class BeanScopeLauncherApplication {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(BeanScopeLauncherApplication.class)) {

            /**
             * this will return the same bean everytime, you'll see the hashcode of a bean as same one
             * com.example.learspring.bean.scope.NormalClass@a1cdc6d
             * com.example.learspring.bean.scope.NormalClass@a1cdc6d
             * com.example.learspring.bean.scope.NormalClass@a1cdc6d
             */
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));

            /**
             * this will return the new instance of a bean everytime, hashcodes will differ in this case
             * com.example.learspring.bean.scope.PrototypeClass@175b9425
             * com.example.learspring.bean.scope.PrototypeClass@3098cf3b
             * com.example.learspring.bean.scope.PrototypeClass@610f7aa
             */
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));

        } catch (NoSuchBeanDefinitionException e) {
            e.printStackTrace();
        }
    }

}
