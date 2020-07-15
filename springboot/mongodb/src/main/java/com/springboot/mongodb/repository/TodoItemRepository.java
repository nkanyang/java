package com.springboot.mongodb.repository;

import com.springboot.mongodb.model.TodoItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoItemRepository extends MongoRepository<TodoItem, Long> {
}
