package com.xieahui.springboot.springaidemo.controller;

import com.xieahui.springboot.springaidemo.service.TextImageModelService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 文字转图片
 * @author: hui.xie
 * @email: xiehui1956@gmail.com
 * @date: 2024/6/30 13:25
 */

@RestController
@RequestMapping("ai")
@AllArgsConstructor
public class TextImageModelController {

    private TextImageModelService textImageModelService;

    @GetMapping("generateImage")
    public String generateImage(@RequestParam(value = "msg", defaultValue = "生成一条高质量的马里努阿犬图片") String msg) {
        return textImageModelService.generateImage(msg);
    }
}
