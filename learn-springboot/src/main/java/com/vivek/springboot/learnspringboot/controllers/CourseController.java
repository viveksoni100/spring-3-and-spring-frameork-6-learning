package com.vivek.springboot.learnspringboot.controllers;

import com.vivek.springboot.learnspringboot.dto.Course;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses() {
        return Arrays.asList(
                new Course(1, "Learn AWS", "in28minutes"),
                new Course(2, "Learn React", "in28minutes"),
                new Course(3, "Learn Angular", "in28minutes"),
                new Course(4, "Learn gRPC", "in28minutes"),
                new Course(5, "Learn MongoDB", "in28minutes")
        );
    }

}
