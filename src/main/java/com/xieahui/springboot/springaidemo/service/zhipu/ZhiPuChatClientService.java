package com.xieahui.springboot.springaidemo.service.zhipu;

import com.xieahui.springboot.springaidemo.service.ChatClientService;
import lombok.AllArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * 我是一个测试用例
 * @description: chatClient service for zhipu chat client service
 * @author: hui.xie
 * @email: xiehui1956@gmail.com
 * @date: 2024/6/27 12:07
 */
@Service
@AllArgsConstructor
public class ZhiPuChatClientService implements ChatClientService {

    private ChatClient chatClient;

    private ChatClient customerChatClient;

    public String chatClient(String msg) {
        return chatClient.prompt().user(msg).call().content();
    }

    public Flux<String> chatClientStream(String msg) {
        return chatClient.prompt().user(msg).stream().content();
    }

    public String customerChatClient(String msg) {
        return customerChatClient.prompt().user(msg).call().content();
    }

}
