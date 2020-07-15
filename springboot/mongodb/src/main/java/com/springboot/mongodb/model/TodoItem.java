package com.springboot.mongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Data
@Document(collection = "todo")
public class TodoItem {
    @Transient
    public static final String SEQUENCE_NAME = "todos_sequence";

    @Id
    private long id;
    private String todo;
    private boolean isDone = false;
    private Date dueDate;
    private Date createDate;
    private Date doneDate;
}
