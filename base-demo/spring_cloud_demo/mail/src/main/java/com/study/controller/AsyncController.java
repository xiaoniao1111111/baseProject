package com.study.controller;

import com.study.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @类名称:Controller
 * @类描述:
 * @包名:com.study
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-14
 * @版本:V1.0.0
 */
@RestController
public class AsyncController {
    @Autowired
    private AsyncService asyncService;

    @GetMapping("/sendMail")
    public String sendMail(){
        asyncService.sendMail();
        return "ok";
    }
}
