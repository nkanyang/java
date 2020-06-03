package com.example.courses.topic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class TopicServiceTest {
    @Autowired
    private TopicService topicService;

    @MockBean
    private TopicRepository topicRepository;

    @BeforeEach
    public void init(){

    }

    @Test
    public void testGetAllTopics(){
        List<Topic> topics = new ArrayList<>(Arrays.asList(
                new Topic("java","java","java basics"),
                new Topic("python","python","python learning")));
        Mockito.when(topicRepository.findAll()).thenReturn(topics);

        List<Topic> result = topicService.getAllTopics();
        assertEquals(topics.size(), result.size());
    }

    @Test
    public void testGetTopic() {
        String id = "java";
        Topic topic = new Topic("java","java","java basics");
        Mockito.when(topicRepository.findById(id)).thenReturn(Optional.of(topic));

        Topic result = topicService.getTopic(id);
        assertEquals(topic, result);
    }

    @Test
    public void testAddTopic() {
        Topic topic = new Topic("java","java","java basics");
        Mockito.when(topicRepository.save(topic)).thenReturn(topic);

        topicService.addTopic(topic);
    }

    @Test
    public void testUpdateTopic() {
        String id = "java";
        Topic topic = new Topic("java","java","java basics");
        Mockito.when(topicRepository.save(topic)).thenReturn(topic);

        topicService.updateTopic(topic,id);
    }

    @Test
    public void testDeleteTopic() {
        String id = "java";
        Mockito.doNothing().when(topicRepository).deleteById(id);

        topicService.deleteTopic(id);
    }
}
