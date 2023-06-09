package com.vivek.myFirstWebApplication.controller;

import com.vivek.myFirstWebApplication.service.ToDoService;
import com.vivek.myFirstWebApplication.todo.Todo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

//@Controller
//@SessionAttributes("name")
public class TodoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping("/list-todos")
    public String listAllTodos(ModelMap modelMap) {
        String username = getLoggedInUsername();
        List<Todo> toDoList = toDoService.findByUsername(username);
        modelMap.put("todos", toDoList);
        return "listTodos";
    }

    private String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @GetMapping("/add-todo")
    public String showNewTodoPage(ModelMap model) {
        String username = getLoggedInUsername();
        Todo toDo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
        model.put("todo", toDo);
        return "todo";
    }

    @PostMapping("/add-todo")
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()) {
            return "todo";
        }
        String username = getLoggedInUsername();
        toDoService.addTodo(username, todo.getDescription(),
                todo.getTargetDate(), false);
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id) {
        toDoService.deleteById(id);
        return "redirect:list-todos";

    }

    @RequestMapping(value="update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
        Todo todo = toDoService.findById(id);
        model.addAttribute("todo", todo);
        return "todo";
    }

    @RequestMapping(value="update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

        if(result.hasErrors()) {
            return "todo";
        }

        String username = getLoggedInUsername();
        todo.setUsername(username);
        toDoService.updateTodo(todo);
        return "redirect:list-todos";
    }

}
