package com.springbootstarter.mysql.courses;

import com.springbootstarter.mysql.courses.entity.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {

}
