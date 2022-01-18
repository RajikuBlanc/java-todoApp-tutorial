package com.todo.app.repository;

import com.todo.app.entity.TodoEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TodoRepository {

    //    リストを全件取得
    @Select("select * from todo_items")
    List<TodoEntity> selectAll();

    //    データベースに追加
    @Insert("insert into todo_items (title,time_limit) values (#{title},now())")
    void add(String title);
    /*
     @Insert("insert into todo_items (title,time_limit) values (#{title}, to_date(#{time_limit},'yyyy-mm-dd'))")
     void add(String title,String time_limit);
    **/

    @Update("update todo_items set title=#{title} where id=${todoId}")
    void update(long todoId, String title);

    @Select("select * from todo_items where id = #{todoId}")
    TodoEntity selectById(long todoId);
}

