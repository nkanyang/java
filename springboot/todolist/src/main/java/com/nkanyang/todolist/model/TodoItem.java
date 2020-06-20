package com.nkanyang.todolist.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "todo")
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    private String todo;

    private boolean done;
}
