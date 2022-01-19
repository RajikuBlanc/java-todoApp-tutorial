package com.todo.app.web.todo;

import lombok.Data;

@Data
public class TodoForm {
    private long id;
    private String title;
    private String time_limit;
}
