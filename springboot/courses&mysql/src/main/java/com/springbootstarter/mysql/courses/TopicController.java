package com.springbootstarter.mysql.courses;

import com.springbootstarter.mysql.courses.entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/topics")
//    @CrossOrigin("http://localhost:8080")
    public List<Topic> getTopics(){
        return topicService.getAllTopics();
    }

    @PostMapping("/topics")
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    @GetMapping("/topics/{id}")
    public Topic getTopicById(@PathVariable String id){
        return topicService.getTopic(id);
    }

    @PutMapping("/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id){
        topicService.updateTopic(topic,id);
    }

    @DeleteMapping("/topics/{id}")
    public void deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
    }
}
