package com.vivek.restfulwebservices.user;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@Entity(name = "user_details")
public class User {

    private Integer id;
    @Size(min = 3)
    private String name;
    @Past   // birthdate should be in the past
    private LocalDate birthDate;

}
