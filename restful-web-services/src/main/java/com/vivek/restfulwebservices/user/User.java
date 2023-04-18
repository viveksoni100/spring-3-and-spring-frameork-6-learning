package com.vivek.restfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity(name = "user_details")
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 3, message = "name should have atleast 3 characters")
    @JsonProperty("user_name")  // customized name
    private String name;

    @Past(message = "birthdate should be in the past")   // birthdate should be in the past
    private LocalDate birthDate;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> posts;

    public User(int id, String name, LocalDate birthdate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthdate;
    }
}
