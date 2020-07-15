package com.springboot.mongodb.service;

import com.springboot.mongodb.model.TodoItem;
import com.springboot.mongodb.repository.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoItemService {
    @Autowired
    private TodoItemRepository todoItemRepository;

    @Autowired
    private SequenceGenerator databaseSequenceService;

    public List<TodoItem> getTodoList(){
        return todoItemRepository.findAll();
    }
    public void addTodoItem(TodoItem todo){
        todo.setId(databaseSequenceService.getNext(TodoItem.SEQUENCE_NAME));
        todoItemRepository.save(todo);
    }

    public void updateTodoItem(long id,TodoItem todo){
        todo.setId(id);
        todoItemRepository.save(todo);
    }

    public void deleteTodoItem(long id){
        todoItemRepository.deleteById(id);
    }
}
