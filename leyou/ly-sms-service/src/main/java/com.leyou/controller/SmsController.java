package com.leyou.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author WangXinWei
 * @Date 2022/6/1 17:03
 * @Version 1.0
 */
@RestController
@RequestMapping("/sms")
public class SmsController {
    @PostMapping("/msg")
    public ResponseEntity sendMsg() {
        return null;
    }
}
