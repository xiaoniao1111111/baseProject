package com.study;

import static org.junit.Assert.assertTrue;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MailApplication.class)
@Slf4j
public class MailTest {
    @Autowired
    private JavaMailSender mailSender;

    /**
     * 简单的邮箱发送
     */
    @Test
    public void sendMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("503899856@qq.com");
        message.setTo("503899856@qq.com");
        message.setSubject("主题: 简单邮件");
        message.setText("正文内容: 测试邮件内容");
        mailSender.send(message);
    }

    /**
     * 发送含有html的邮件
     */
    @Test
    public void sendMail2() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setFrom("503899856@qq.com");
        helper.setTo("503899856@qq.com");
        helper.setSubject("主题: 发送含有html的邮件");
        // 参数一: 邮件内容  参数而: 是否是标签内容, true:是   false: 否
        helper.setText("<h1> 验证码: 123456 </h2>",true);
        mailSender.send(mimeMessage);
    }

    /**
     * 发送含有图片的邮件(正文的形式)
     * 思路:
     * 1. 邮件设置为:多资源,多附件
     * 2. 设置图片
     * 2.1 定义图片ID
     * 2.2 定义图片资源
     * 2.3 通过addInline存储图片
     * 2.4 将图片作为附件的形式存在
     */
    @Test
    public void sendMail3() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        // multipart: true 表示这个邮件是多资源,多附件的邮件
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setFrom("503899856@qq.com");
        helper.setTo("503899856@qq.com");
        helper.setSubject("主题: 发送含有图片的邮件");
        // 参数一: 邮件内容  参数而: 是否是标签内容, true:是   false: 否
        String id = "11";
        String path = "D:\\img\\11.jpg";
        FileSystemResource resource = new FileSystemResource(new File(path));
        helper.setText("<h1> 图片: </h2><img src='cid:"+id+"'/>", true);
        // 以正文的形式展示图片
        helper.addInline(id,resource);
        mailSender.send(mimeMessage);
    }

    /**
     * 发送含有图片的邮件(附件的形式)
     * 思路:
     * 1. 邮件设置为:多资源,多附件
     * 2. 设置图片
     * 2.1 定义图片ID
     * 2.2 定义图片资源
     * 2.3 通过addInline存储图片
     * 2.4 将图片作为附件的形式存在
     */
    @Test
    public void sendMail4() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        // multipart: true 表示这个邮件是多资源,多附件的邮件
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setFrom("503899856@qq.com");
        helper.setTo("503899856@qq.com");
        helper.setSubject("主题: 发送含有图片的邮件");
        // 参数一: 邮件内容  参数而: 是否是标签内容, true:是   false: 否
        String id = "11";
        String path = "D:\\img\\11.jpg";
        FileSystemResource resource = new FileSystemResource(new File(path));
        helper.setText("<h1> 图片: </h2><img src='cid:"+id+"'/>", true);
        // 将图片作为附件的形式展示
        helper.addAttachment("11.jpg",resource);
        mailSender.send(mimeMessage);
    }


}
