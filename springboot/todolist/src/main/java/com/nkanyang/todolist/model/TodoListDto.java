package com.nkanyang.todolist.model;

import lombok.Data;

import java.util.List;

@Data
public class TodoListDto {
    private List<TodoItem> todoItemList;
}
