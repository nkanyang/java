package com.nkanyang.todolist;

import com.nkanyang.todolist.model.TodoItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoListRepository extends CrudRepository<TodoItem, Long> {
    public List<TodoItem> findByDoneFalse();
    public List<TodoItem> findByDoneTrue();
}
