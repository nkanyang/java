package com.nkanyang.todolist;

import com.nkanyang.todolist.model.TodoItem;
import com.nkanyang.todolist.model.TodoListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoListService {
    @Autowired
    private TodoListRepository todoListRepository;

    public TodoListDto getAllItems() {
        TodoListDto todoList = new TodoListDto();
        List<TodoItem> list = (List<TodoItem>)todoListRepository.findAll();
        todoList.setTodoItemList(list);
        return todoList;
    }

    public TodoListDto getItems(boolean isDone) {
        TodoListDto todoList = new TodoListDto();
        List<TodoItem> list = null;
        if(isDone) {
           list = todoListRepository.findByDoneTrue();
        }
        else{
            list = todoListRepository.findByDoneFalse();
        }
        todoList.setTodoItemList(list);
        return todoList;
    }

    public TodoItem addTodoItem(TodoItem todoItem) {
        todoListRepository.save(todoItem);
        return todoItem;
    }

    public void updateTodoItem(TodoItem todoItem) {
        todoListRepository.save(todoItem);
    }

    public void deleteTodoItem(TodoItem todoItem) {
        todoListRepository.delete(todoItem);
    }

}
