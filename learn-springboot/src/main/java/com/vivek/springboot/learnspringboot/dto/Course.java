package com.vivek.springboot.learnspringboot.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Course {

    private int id;
    private String name;
    private String tutor;

    public Course(int id, String name, String tutor) {
        this.id = id;
        this.name = name;
        this.tutor = tutor;
    }
}
