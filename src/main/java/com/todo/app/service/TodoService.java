package com.todo.app.service;

import com.todo.app.entity.TodoEntity;
import com.todo.app.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    public final TodoRepository todoRepository;

    public List<TodoEntity> selectAll() {
        return todoRepository.selectAll();
    }

    @Transactional
    public void add(String title) {
        todoRepository.add(title);
    }

    public TodoEntity selectById(long todoId) {
        return todoRepository.selectById(todoId);
    }

    public void update(long id, String title) {
        todoRepository.update(id, title);
    }
}
