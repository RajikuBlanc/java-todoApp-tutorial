package com.todo.app.web.todo;

import com.todo.app.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping
    public String showTodo(@ModelAttribute TodoForm form, Model model) {
        model.addAttribute("todos", todoService.selectAll());
        return "index";
    }

    @PostMapping("/add")
    public String addTodo(TodoForm form) {
        todoService.add(form.getTitle());
        return "redirect:/";
    }

    @GetMapping("/update/{todoId}")
    public String updateShowTodo(@PathVariable("todoId") long todoId, @ModelAttribute TodoForm form, Model model) {
        model.addAttribute("todo", todoService.selectById(todoId));

        return "todo/update";
    }

    @PostMapping("/update")
    public String updateTodo(TodoForm form) {
        todoService.update(form.getId(), form.getTitle());
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteTodo(TodoForm form) {
        todoService.delete(form.getId());
        return "redirect:/";
    }
}
