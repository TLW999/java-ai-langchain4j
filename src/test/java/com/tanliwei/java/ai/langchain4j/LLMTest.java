package com.tanliwei.java.ai.langchain4j;


import dev.langchain4j.model.openai.OpenAiChatModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LLMTest {

//    @Test
//    public void testGPTDemo(){
//
//        OpenAiChatModel model = OpenAiChatModel.builder()
//                .baseUrl("http://langchain4j.dev/demo/openai/v1")
//                .apiKey("demo")
//                .modelName("gpt-4o-mini")
//                .build();
//
//
//        String result = model.chat("你好");
//        System.out.println(result);
//
//    }

    @Autowired
    private OpenAiChatModel openAiChatModel;

    @Test
    public void testOpenAIDemo(){
        String response = openAiChatModel.chat("我是谁？");
        System.out.println(response);
    }
}
