package com.vivek.learnjpaandhibernate.course.jdbc;

import com.vivek.learnjpaandhibernate.course.dto.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class JdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn AWS", "in28minutes"));
        repository.insert(new Course(2, "Learn Azure", "in28minutes"));
        repository.insert(new Course(3, "Learn Angular", "in28minutes"));
        repository.insert(new Course(4, "Learn React", "in28minutes"));

        // repository.deleteById(2);

        // System.out.println(repository.findById(4));
    }
}
