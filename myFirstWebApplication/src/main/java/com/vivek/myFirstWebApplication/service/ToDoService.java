package com.vivek.myFirstWebApplication.service;

import com.vivek.myFirstWebApplication.todo.Todo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class ToDoService {

    private static List<Todo> todos = new ArrayList<>();
    private static int todosCount = 0;

    static {
        todos.add(new Todo(++todosCount, "vivek", "Learn react", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "vivek", "Learn angular", LocalDate.now().plusYears(2), false));
        todos.add(new Todo(++todosCount, "vivek", "Learn spring security", LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUsername(String username) {
        Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate, Boolean done) {
        Todo toDo = new Todo(++todosCount, username, description, targetDate, done);
        todos.add(toDo);
    }

    public void deleteById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public void updateTodo(@Valid Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

}
