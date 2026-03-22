package com.tanliwei.java.ai.langchain4j.tools;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.agent.tool.ToolMemoryId;
import org.springframework.stereotype.Component;

@Component
public class CalculatorTools {

    @Tool(name = "加法运算",value = "")
    double sum(@ToolMemoryId int memoryId, @P(value = "描述") double a, double b) {
        System.out.println("调用加法运算");
        System.out.println(memoryId);
        return a + b;
    }

    @Tool(name = "平方根运算")
    double squareRoot(@ToolMemoryId int memoryId,double x) {
        System.out.println("调用平方根运算");
        return Math.sqrt(x);
    }
}
