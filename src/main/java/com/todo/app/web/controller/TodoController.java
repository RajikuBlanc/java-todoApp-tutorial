package com.todo.app.web.controller;

import com.todo.app.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping
    public String showTodo(Model model){
        model.addAttribute("todos",todoService.selectAll());
        return "index";
    }
}
