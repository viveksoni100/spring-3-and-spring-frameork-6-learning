package com.vivek.restfulwebservices.exception;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ErrorDetails {

    private LocalDateTime timestamp;
    private String message;
    private String details;

}
