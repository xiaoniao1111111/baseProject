package com.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @类名称:AsyncService
 * @类描述: 发送邮件service
 * @包名:com.study.service
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-14
 * @版本:V1.0.0
 */
@Service
public class AsyncService {
    @Autowired
    private JavaMailSender mailSender;

    /**
     * 返回结果和邮件发送 分别异步执行
     */
    @Async
    public void sendMail() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("503899856@qq.com");
        message.setTo("503899856@qq.com");
        message.setSubject("主题: 简单邮件");
        message.setText("正文内容: 测试邮件内容");
        mailSender.send(message);
    }
}
