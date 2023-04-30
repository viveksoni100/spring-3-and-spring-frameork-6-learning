package com.vivek.restfulwebservices.todo;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Todo {

    private Integer id;

    private String username;

    private String description;

    private LocalDate targetDate;

    private boolean done;

}
