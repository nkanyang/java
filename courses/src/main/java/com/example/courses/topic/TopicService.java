package com.example.courses.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;
//    private List<Topic> topics = new ArrayList<>(Arrays.asList(
//            new Topic("java","java","java basics"),
//            new Topic("python","python","python learning"))
//    );

    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll()
                .forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id){
        final Optional<Topic> topic = topicRepository.findById(id);
        return topic.get();
    }

    public void addTopic(Topic topic){
        topicRepository.save(topic);
        return;
    }

    public void updateTopic(Topic topic, String id){
        topicRepository.save(topic);
        return;
    }

    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
        return;
    }
}
