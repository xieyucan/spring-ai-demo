package com.xieahui.springboot.springaidemo.service.zhipu;

import com.xieahui.springboot.springaidemo.service.TextImageModelService;
import lombok.AllArgsConstructor;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.zhipuai.ZhiPuAiImageModel;
import org.springframework.ai.zhipuai.ZhiPuAiImageOptions;
import org.springframework.stereotype.Service;

/**
 * @description: 文生成图片模型服务
 * @author: hui.xie
 * @email: xiehui1956@gmail.com
 * @date: 2024/6/27 12:08
 */

@Service
@AllArgsConstructor
public class ZhiPuTextImageModelService implements TextImageModelService {

    private ZhiPuAiImageModel zhiPuAiImageModel;

    @Override
    public String generateImage(String msg) {
        ImageResponse response = zhiPuAiImageModel.call(
                new ImagePrompt(msg,
                        ZhiPuAiImageOptions.builder().withModel("CogView-3").build())

        );
        return response.getResult().getOutput().getB64Json();
    }
}
