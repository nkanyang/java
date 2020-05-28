package com.springbootstarter.mysql.courses.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name="Topics"):add this if the class name doesn't match table name
public class Topic {

    @Id
    private String id;
//    @Column(name="topic_name") add this if the variable name doesn't match column name
    private String name;
    private String description;

    @OneToMany(mappedBy = "topic")
    private List<Course> courses = new ArrayList<>();

    public Topic() {
    }

    public Topic(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
