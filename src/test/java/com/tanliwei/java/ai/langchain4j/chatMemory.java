package com.tanliwei.java.ai.langchain4j;


import com.tanliwei.java.ai.langchain4j.assistant.Assistant;
import com.tanliwei.java.ai.langchain4j.assistant.MemoryChatAssistant;
import com.tanliwei.java.ai.langchain4j.assistant.SeparateChatAssistant;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class chatMemory {

    @Autowired
    private Assistant assistant;

    @Autowired
    private QwenChatModel qwenChatModel;

    @Autowired
    private MemoryChatAssistant memoryChatAssistant;

    @Autowired
    private SeparateChatAssistant separateChatAssistant;

    @Test
    public void testChatMemory() {

        //第一轮对话
        UserMessage usermessage = UserMessage.userMessage("我是小红");
        ChatResponse chatResponse = qwenChatModel.chat(usermessage);
        AiMessage aiMessage = chatResponse.aiMessage();


        //第二轮对话
        UserMessage usermessage2 = UserMessage.userMessage("我是谁？");
        ChatResponse chatResponse2 = qwenChatModel.chat(Arrays.asList(usermessage,aiMessage,usermessage2));
        AiMessage aiMessage2 = chatResponse2.aiMessage();
        System.out.println(aiMessage2.text());
    }

    @Test
    public void testChatMemory3() {
        MessageWindowChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(10);

        Assistant assistant = AiServices.builder(Assistant.class)
                .chatLanguageModel(qwenChatModel)
                .chatMemory(chatMemory)
                .build();

        String chat1 = assistant.chat("我是小明");
        String chat2 = assistant.chat("我是谁？");
        System.out.println(chat1);
        System.out.println(chat2);

    }

    @Test
    public void testChatMemory4() {
        String answer1 = separateChatAssistant.chat(1,"我是谁？");
        System.out.println(answer1);
        String answer2 = separateChatAssistant.chat(1,"我是谁？");
        System.out.println(answer2);
        String answer3 = separateChatAssistant.chat(2, "我是谁？");
        System.out.println(answer3);
    }

    @Test
    public void testChatMemory5() {
        String answer1 = memoryChatAssistant.chat("我是环环");
        System.out.println(answer1);

        String answer2 = memoryChatAssistant.chat("我18岁了");
        System.out.println(answer2);

        String answer3 = memoryChatAssistant.chat("who am I?");
        System.out.println(answer3);
    }
}
