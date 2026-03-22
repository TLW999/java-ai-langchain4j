package com.tanliwei.java.ai.langchain4j.config;


import com.tanliwei.java.ai.langchain4j.store.MongoChatMemoryStore;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class chatMemoryProviderXiaozhiConfig {

    @Autowired
    private MongoChatMemoryStore chatMemoryStore;


    @Bean
    public ChatMemoryProvider chatMemoryProviderXiaozhi() {
        return memoryId -> MessageWindowChatMemory.builder().id(memoryId).maxMessages(20).chatMemoryStore(chatMemoryStore).build();
    }

}
