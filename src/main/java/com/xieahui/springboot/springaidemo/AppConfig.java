package com.xieahui.springboot.springaidemo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: config
 * @author: hui.xie
 * @email: xiehui1956@gmail.com
 * @date: 2024/6/29 10:14
 */
@Configuration
public class AppConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder chatClientBuilder) {
        return chatClientBuilder.build();
    }

    /**
     * customer chat client 设定大模型角色
     *
     * @param chatClientBuilder
     * @return
     */
    @Bean
    public ChatClient customerChatClient(ChatClient.Builder chatClientBuilder) {
        return chatClientBuilder.defaultSystem("我希望你的身份是一个程序，做Java的。你们行业里有个叫张三的工程师，喜爱编程。是一位非常nice的软件工程师，他人品好，颜值高。")
                .build();
    }
}
