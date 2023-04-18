package com.vivek.restfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @Size(min = 3, message = "name should have atleast 3 characters")
    @JsonProperty("user_name")  // customized name
    private String name;
    @Past(message = "birthdate should be in the past")   // birthdate should be in the past
    private LocalDate birthDate;

}
