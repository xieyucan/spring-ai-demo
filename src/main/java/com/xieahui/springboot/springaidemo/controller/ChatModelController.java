package com.xieahui.springboot.springaidemo.controller;

import com.xieahui.springboot.springaidemo.service.zhipu.ZhiPuChatModelService;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @description: chatModel controller for zhipu chat model service
 * @author: hui.xie
 * @email: xiehui1956@gmail.com
 * @date: 2024/6/29 18:49
 */
@RestController
@AllArgsConstructor
@RequestMapping("ai")
public class ChatModelController {

    @Resource
    private ZhiPuChatModelService zhiPuChatModelService;

    @GetMapping("chatModel")
    public String chatModel(@RequestParam(value = "msg", defaultValue = "介绍下你自己") String msg) {
        return zhiPuChatModelService.chatModel(msg);
    }

    @GetMapping(value = "chatModelStream", produces = "text/html;charset=utf-8")
    public Flux<String> chatModelStream(@RequestParam(value = "msg", defaultValue = "介绍下XA协议") String msg) {
        return zhiPuChatModelService.chatModelStream(msg);
    }

}
