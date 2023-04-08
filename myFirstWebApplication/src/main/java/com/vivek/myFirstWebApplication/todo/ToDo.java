package com.vivek.myFirstWebApplication.todo;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ToDo {

    private int id;
    private String username;
    private String description;
    private LocalDate targetDate;
    private boolean done;

}
