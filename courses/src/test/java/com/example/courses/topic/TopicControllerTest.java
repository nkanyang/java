package com.example.courses.topic;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//        1 MockMvcBuilder构造MockMvc的构造器
//
//        2 MockMvcRequestBuilders创建请求request
//
//        3 mockMvc调用perform，执行一个request请求，调用controller的业务处理逻辑，返回ResultActions
//
//        4 可以通过ResultActions, MockMvcResultMatchers对结果进行验证

@WebMvcTest(TopicController.class)
public class TopicControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TopicService topicService;

    @Test
    public void testGetAllTopics() throws Exception{
        //prepare service data
        List<Topic> topics = new ArrayList<>(Arrays.asList(
                new Topic("java","java","java basics")));
        BDDMockito.when(topicService.getAllTopics()).thenReturn(topics);

        //prepare a get request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/topics");

        //send request
        ResultActions perform = mockMvc.perform(request);

        // verify the result with expected value
        perform.andExpect(MockMvcResultMatchers.status().isOk());

        perform.andExpect(content().json("[{\"id\":\"java\",\"name\":\"java\",\"description\":\"java basics\"}]"));
    }

    @Test
    public void testGetTopic() throws Exception{
        //prepare service data
        String id = "java";
        Topic topic = new Topic("java","java","java basics");
        BDDMockito.when(topicService.getTopic(id)).thenReturn(topic);

        //prepare a get request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/topics/" + id);

        //send request
        ResultActions perform = mockMvc.perform(request);

        // verify the result with expected value
        perform.andExpect(MockMvcResultMatchers.status().isOk());

        perform.andExpect(content().json("{\"id\":\"java\",\"name\":\"java\",\"description\":\"java basics\"}"));
    }

    @Test
    public void testAddTopic() throws Exception{
        //prepare service data
        Topic topic = new Topic("java","java","java basics");
        BDDMockito.doNothing().when(topicService).addTopic(topic);

        //prepare a get request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/topics")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":\"java\",\"name\":\"java\",\"description\":\"java basics\"}");

        mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testUpdateTopic() throws Exception{
        //prepare service data
        String id = "java";
        Topic topic = new Topic("java","java","java basics");
        BDDMockito.doNothing().when(topicService).updateTopic(topic,id);

        //prepare a get request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .put("/topics/" + id)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":\"java\",\"name\":\"java\",\"description\":\"java basics\"}");

        mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testDeleteTopic() throws Exception{
        //prepare service data
        String id = "java";
        BDDMockito.doNothing().when(topicService).deleteTopic(id);

        //prepare a get request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .delete("/topics/" + id)
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
