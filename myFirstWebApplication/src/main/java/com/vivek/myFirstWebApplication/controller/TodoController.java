package com.vivek.myFirstWebApplication.controller;

import com.vivek.myFirstWebApplication.service.ToDoService;
import com.vivek.myFirstWebApplication.todo.ToDo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping("/add-todo")
    public String showNewTodoPage(ModelMap model) {
        String username = (String) model.get("name");
        ToDo toDo = new ToDo(0, username, "", LocalDate.now().plusYears(1), false);
        model.put("todo", toDo);
        return "todo";
    }

    @PostMapping("/add-todo")
    public String addNewTodo(ModelMap model, @Valid ToDo todo, BindingResult result) {
        if(result.hasErrors()) {
            return "todo";
        }
        String username = todo.getUsername();
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
        ToDo todo = toDoService.findById(id);
        model.addAttribute("todo", todo);
        return "todo";
    }

    @RequestMapping(value="update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid ToDo todo, BindingResult result) {

        if(result.hasErrors()) {
            return "todo";
        }

        String username = todo.getUsername();
        todo.setUsername(username);
        toDoService.updateTodo(todo);
        return "redirect:list-todos";
    }

}
