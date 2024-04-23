package com.study.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @类名称:ScheduledService
 * @类描述:
 * @包名:com.study.service
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-14
 * @版本:V1.0.0
 */
@Service
@Slf4j
public class ScheduledService {

    @Autowired
    private JavaMailSender mailSender;

    @Scheduled(cron = "*/5 * * * * ?")
    public void task(){
        log.info("邮件发送开始");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("503899856@qq.com");
        message.setTo("503899856@qq.com");
        message.setSubject("主题: 简单邮件");
        message.setText("正文内容: 测试邮件内容");
        mailSender.send(message);
        log.info("邮件发送结束");
    }
}
