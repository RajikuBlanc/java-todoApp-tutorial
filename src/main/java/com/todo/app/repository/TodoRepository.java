package com.todo.app.repository;

import com.todo.app.entity.TodoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TodoRepository {
    @Select("select * from todo_items")
    List<TodoEntity> selectAll();
}
