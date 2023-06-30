package com.vivek.restfulwebservices.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Todo {

    @Id
    @GeneratedValue
    private Integer id;

    private String username;

    private String description;

    private LocalDate targetDate;

    private boolean done;

}
