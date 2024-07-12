package com.xieahui.springboot.springaidemo.controller;

import com.xieahui.springboot.springaidemo.service.ChatClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @description: chatClient controller for zhipu chat client service
 * @author: hui.xie
 * @email: xiehui1956@gmail.com
 * @date: 2024/6/26 10:58
 */
@RestController
@AllArgsConstructor
@RequestMapping("/ai")
public class ChatClientController {

    private ChatClientService chatClientService;

    /**
     * 聊天 文本
     *
     * @param msg 内容
     * @return 返回会话内容
     */
    @GetMapping("chatClient")
    public String chatClient(@RequestParam(value = "msg", defaultValue = "了解 张三java的博客 吗？") String msg) {
        return chatClientService.chatClient(msg);
    }

    /**
     * 聊天 文本流
     *
     * @param msg 内容
     * @return 返回会话内容
     */
    @GetMapping(value = "chatClientStream", produces = "text/html;charset=utf-8")
    public Flux<String> chatClientStream(@RequestParam(value = "msg", defaultValue = "了解 张三java的博客 吗？") String msg) {
        return chatClientService.chatClientStream(msg);
    }

    /**
     * 自定义角色
     *
     * @param msg 内容
     * @return 返回会话内容
     */
    @GetMapping("customerChatClient")
    public String customerChatClient(@RequestParam(value = "msg", defaultValue = "了解 张三java的博客 吗？") String msg) {
        return chatClientService.customerChatClient(msg);
    }

}
