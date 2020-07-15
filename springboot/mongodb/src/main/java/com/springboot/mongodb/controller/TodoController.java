package com.springboot.mongodb.controller;

import com.springboot.mongodb.model.TodoItem;
import com.springboot.mongodb.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todolist")
public class TodoController {
    @Autowired
    private TodoItemService todoItemService;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<TodoItem> getList(){
        return todoItemService.getTodoList();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addTodo(@RequestBody TodoItem todo){
        todoItemService.addTodoItem(todo);
    }

    @PutMapping("{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateTodo(@PathVariable long id, @RequestBody TodoItem todo){
        todoItemService.updateTodoItem(id, todo);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteTodo(@PathVariable long id){
        todoItemService.deleteTodoItem(id);
    }
}
