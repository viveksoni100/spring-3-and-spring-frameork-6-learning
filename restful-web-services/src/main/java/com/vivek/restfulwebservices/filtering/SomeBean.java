package com.vivek.restfulwebservices.filtering;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SomeBean {

    private String field1;

    private String field2;

    //@JsonIgnore - static filtering
    private String field3;

}
