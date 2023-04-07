package com.vivek.learnjpaandhibernate.course.jdbc.n.jpa;

import com.vivek.learnjpaandhibernate.course.entities.Course;
import com.vivek.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.vivek.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    // @Autowired
    // private CourseJdbcRepository repository;

    // @Autowired
    // private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        /**
         * using jdbc and jpa
         */
        /*repository.insert(new Course(1, "Learn AWS", "in28minutes"));
        repository.insert(new Course(2, "Learn Azure", "in28minutes"));
        repository.insert(new Course(3, "Learn Angular", "in28minutes"));
        repository.insert(new Course(4, "Learn React", "in28minutes"));
        repository.deleteById(2);
        System.out.println(repository.findById(4));*/

        /**
         * using spring data jpa
         */
        repository.save(new Course(1, "Learn AWS JPA", "in28minutes"));
        repository.save(new Course(2, "Learn Azure JPA", "in28minutes"));
        repository.save(new Course(3, "Learn Angular JPA", "in28minutes"));
        repository.save(new Course(4, "Learn React JPA", "in28minutes"));
        repository.deleteById(2l);
        System.out.println(repository.findById(4l));
    }
}
