package com.study;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.junit.Test;

/**
 * @类名称:GenerateTableTest
 * @类描述:
 * @包名:com.study
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-14
 * @版本:V1.0.0
 */
public class GenerateTableTest {
    /**
     * 生成 activiti的数据库表
     */
    @Test
    public void testCreateDbTable() {
        // 直接使用activiti提供的工具类ProcessEngines，会默认读取classpath下的activiti.cfg.xml文件，
        // 读取其中的数据库配置，创建 ProcessEngine，在创建ProcessEngine 时会自动创建表
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        System.out.println(processEngine);
    }
}
