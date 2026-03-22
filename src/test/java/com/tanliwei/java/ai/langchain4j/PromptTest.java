package com.tanliwei.java.ai.langchain4j;


import com.tanliwei.java.ai.langchain4j.assistant.SeparateChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PromptTest {
    @Autowired
    private SeparateChatAssistant separateChatAssistant;


    @Test
    public void testSystemMessage() {
        String answer = separateChatAssistant.chat(3,"你好，我是小明");
        System.out.println(answer);
    }
}
