package com.vivek.myFirstWebApplication.service;

import com.vivek.myFirstWebApplication.todo.ToDo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class ToDoService {

    private static List<ToDo> todos = new ArrayList<>();
    private static int todosCount = 0;

    static {
        todos.add(new ToDo(++todosCount, "vivek", "Learn react", LocalDate.now().plusYears(1), false));
        todos.add(new ToDo(++todosCount, "vivek", "Learn angular", LocalDate.now().plusYears(2), false));
        todos.add(new ToDo(++todosCount, "vivek", "Learn spring security", LocalDate.now().plusYears(3), false));
    }

    public List<ToDo> findByUsername(String username) {
        return todos;
    }

    public void addTodo(String username, String description, LocalDate targetDate, Boolean done) {
        ToDo toDo = new ToDo(++todosCount, username, description, targetDate, done);
        todos.add(toDo);
    }

    public void deleteById(int id) {
        Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public void updateTodo(@Valid ToDo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }

    public ToDo findById(int id) {
        Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
        ToDo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

}
