package com.vivek.myFirstWebApplication.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Todo {

    @Id
    @GeneratedValue
    private int id;
    private String username;
    @Size(min = 10, message = "Enter atleast 10 characters")
    private String description;
    private LocalDate targetDate;
    private boolean done;

}
