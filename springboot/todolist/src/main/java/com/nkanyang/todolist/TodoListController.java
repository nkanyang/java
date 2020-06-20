package com.nkanyang.todolist;

import com.nkanyang.todolist.model.TodoItem;
import com.nkanyang.todolist.model.TodoListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todolist")
public class TodoListController {
    @Autowired
    private TodoListService todoListService;

    @GetMapping
    public TodoListDto getAllItems(){
        return todoListService.getAllItems();
    }

    @GetMapping("all")
    public TodoListDto getDoneItems(@RequestParam(name = "done") boolean isDone){
        return todoListService.getItems(isDone);
    }

    @PostMapping
    public TodoItem addTodoItem(@RequestBody TodoItem todoItem){
        return todoListService.addTodoItem(todoItem);
    }

    @PutMapping
    public void updateTodoItem(@RequestBody TodoItem todoItem){
        todoListService.updateTodoItem(todoItem);
    }

    @DeleteMapping
    public void deleteTodoItem(@RequestBody TodoItem todoItem){
        todoListService.deleteTodoItem(todoItem);
    }
}
