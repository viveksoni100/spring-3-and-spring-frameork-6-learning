package com.vivek.restfulwebservices.user;

import jakarta.persistence.Entity;
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
    private String name;
    private LocalDate birthDate;

}
