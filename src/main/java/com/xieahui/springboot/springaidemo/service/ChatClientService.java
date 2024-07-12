package com.xieahui.springboot.springaidemo.service;

import reactor.core.publisher.Flux;

/**
 * @description: some desc
 * @author: hui.xie
 * @email: xiehui1956@gmail.com
 * @date: 2024/6/30 13:29
 */
public interface ChatClientService {

    String chatClient(String msg);

    Flux<String> chatClientStream(String msg);

    String customerChatClient(String msg);
}
