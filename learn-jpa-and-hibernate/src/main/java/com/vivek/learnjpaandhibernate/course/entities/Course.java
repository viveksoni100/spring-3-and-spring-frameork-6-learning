package com.vivek.learnjpaandhibernate.course.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Course {

    @Id
    private long id;
    private String name;
    private String author;

}
