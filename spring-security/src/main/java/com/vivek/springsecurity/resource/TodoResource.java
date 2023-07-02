package com.vivek.springsecurity.resource;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class TodoResource {

    private static final List<Todo> TODOS_LIST =
            List.of(new Todo("vivek", "Learn AWS"),
                    new Todo("vivek", "Learn Docker"));

    @GetMapping("/todos")
    public List<Todo> getAllTodos() {
        return TODOS_LIST;
    }

    @GetMapping("/users/{username}/todos")
    public Todo getAllTodosForSpecificUser(@PathVariable String username) {
        return TODOS_LIST.get(0);
    }

    @PostMapping("/users/{username}/todos")
    public void createTodosForSpecificUser(@PathVariable String username,
                                           @RequestBody Todo todo) {
        log.info("Create {} for {}", todo, username);
    }
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Todo {
    String username;
    String description;
}
