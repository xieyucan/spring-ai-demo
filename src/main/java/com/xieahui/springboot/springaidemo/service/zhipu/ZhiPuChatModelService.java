package com.xieahui.springboot.springaidemo.service.zhipu;

import com.xieahui.springboot.springaidemo.service.ChatModelService;
import lombok.AllArgsConstructor;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.zhipuai.ZhiPuAiChatModel;
import org.springframework.ai.zhipuai.ZhiPuAiChatOptions;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * @description: some desc
 * @author: hui.xie
 * @email: xiehui1956@gmail.com
 * @date: 2024/6/27 12:07
 * */


@Service
@AllArgsConstructor
public class ZhiPuChatModelService implements ChatModelService {

    private ZhiPuAiChatModel chatModel;

    @Override
    public String chatModel(String msg) {
        return chatModel.call(new Prompt(msg, ZhiPuAiChatOptions.builder().withModel("GLM-4-0520")
                        .withTemperature(0.6F).build()))
                .getResult()
                .getOutput()
                .getContent();
    }

    @Override
    public Flux<String> chatModelStream(String msg) {
        return chatModel.stream(new Prompt(msg, ZhiPuAiChatOptions.builder()
                        .withModel("GLM-4-0520")
                        .withTemperature(0.6F)
                        .build()))
                .map(chatResponse -> chatResponse.getResults().get(0).getOutput().getContent());
    }
}
