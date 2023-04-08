package com.vivek.myFirstWebApplication.controller;

import com.vivek.myFirstWebApplication.service.ToDoService;
import com.vivek.myFirstWebApplication.todo.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping("/list-todos")
    public String listAllTodos(ModelMap modelMap) {
        List<ToDo> toDoList = toDoService.findByUsername("vivek");
        modelMap.put("todos", toDoList);
        return "listTodos";
    }

}
