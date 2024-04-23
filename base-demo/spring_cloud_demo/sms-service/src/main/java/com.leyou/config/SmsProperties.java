package com.leyou.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 读取配置文件并组装成对象
 *
 * @Author WangXinWei
 * @Date 2022/6/1 17:20
 * @Version 1.0
 */
@ConfigurationProperties(prefix = "ly.sms")
public class SmsProperties {
    String accessKeyId;

    String accessKeySecret;

    String signName;

    String verifyCodeTemplate;

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getVerifyCodeTemplate() {
        return verifyCodeTemplate;
    }

    public void setVerifyCodeTemplate(String verifyCodeTemplate) {
        this.verifyCodeTemplate = verifyCodeTemplate;
    }
}
