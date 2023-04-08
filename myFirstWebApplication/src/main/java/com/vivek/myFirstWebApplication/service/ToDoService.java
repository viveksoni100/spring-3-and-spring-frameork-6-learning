package com.vivek.myFirstWebApplication.service;

import com.vivek.myFirstWebApplication.todo.ToDo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {

    private static List<ToDo> todos = new ArrayList<>();

    static {
        todos.add(new ToDo(1, "vivek", "Learn react", LocalDate.now().plusYears(1), false));
        todos.add(new ToDo(1, "vivek", "Learn angular", LocalDate.now().plusYears(2), false));
        todos.add(new ToDo(1, "vivek", "Learn spring security", LocalDate.now().plusYears(3), false));
    }

    public List<ToDo> findByUsername(String username) {
        return todos;
    }

}
