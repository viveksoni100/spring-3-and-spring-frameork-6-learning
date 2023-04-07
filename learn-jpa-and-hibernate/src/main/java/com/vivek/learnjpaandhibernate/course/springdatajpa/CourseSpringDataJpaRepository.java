package com.vivek.learnjpaandhibernate.course.springdatajpa;

import com.vivek.learnjpaandhibernate.course.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
}
