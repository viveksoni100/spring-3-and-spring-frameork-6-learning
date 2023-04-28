package com.in28minutes.rest.webservices.restfulwebservices.jwt;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JwtTokenRequest {
    String username;
    String password;
}
