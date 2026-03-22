package com.tanliwei.java.ai.langchain4j;


import com.tanliwei.java.ai.langchain4j.bean.ChatMessages;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;


@SpringBootTest
public class MongoCrudTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void insert() {
        ChatMessages chatMessages = new ChatMessages();
        chatMessages.setContent("你好，我是张三");
        mongoTemplate.insert(chatMessages);
    }

    @Test
    public void testUpdate() {
        Criteria criteria = Criteria.where("_id").is("69be5515b8a0f62497a07c79");
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("content", "新的聊天记录");

        mongoTemplate.upsert(query, update, ChatMessages.class);
    }
}
