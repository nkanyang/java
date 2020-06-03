package com.example.courses;

import com.example.courses.topic.TopicController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SmokeTest {
    @Autowired
    private TopicController topicController;

    @Test
    void contextLoads() {
        assertNotNull(topicController);
    }

}
