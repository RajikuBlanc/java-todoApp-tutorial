package com.todo.app.service;

import com.todo.app.entity.TodoEntity;
import com.todo.app.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    public final TodoRepository todoRepository;

    public List<TodoEntity> selectAll(){
        return todoRepository.selectAll();
    }
}
