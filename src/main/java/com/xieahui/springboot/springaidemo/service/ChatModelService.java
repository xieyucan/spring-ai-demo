package com.xieahui.springboot.springaidemo.service;

import reactor.core.publisher.Flux;

/**
 * @description: some desc
 * @author: hui.xie
 * @email: xiehui1956@gmail.com
 * @date: 2024/6/30 13:32
 */
public interface ChatModelService {

    String chatModel(String msg);

    Flux<String> chatModelStream(String msg);
}
