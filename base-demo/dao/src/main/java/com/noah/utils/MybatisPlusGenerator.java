package com.noah.utils;


import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.BeetlTemplateEngine;
import org.apache.logging.log4j.util.Strings;

import java.util.Scanner;

/**
 * @Author: WangXinWei
 * @Date: 2019/5/29 16:27
 * @Version 1.0
 */

public class MybatisPlusGenerator {
    public static void main(String[] args) {
        //代码生成器 如果您选择了非默认引擎，需要在 AutoGenerator 中 设置模板引擎。
        AutoGenerator mpg = new AutoGenerator();
        /**
         * 设置模板引擎
         * */
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setService(null);
        templateConfig.setServiceImpl(null);
        templateConfig.setController(null);
        //代码生成器的模板配置
        mpg.setTemplate(templateConfig);
        //切换模板引擎
        mpg.setTemplateEngine(new BeetlTemplateEngine());
        /**
         * 生成器全局配置
         * */
        GlobalConfig globalConfig = new GlobalConfig();
        //项目路径
        String daoProjectPath = "/generator";
        String property = System.getProperty("user.dir");
        //生成文件的输出目录
        globalConfig.setOutputDir(property + daoProjectPath + "/src/main/java");
        //开发人员及作者
        globalConfig.setAuthor("wxw");
        //是否打开输出目录 todo 待验
        globalConfig.setOpen(false);
        //是否覆盖已有文件
        globalConfig.setFileOverride(true);
        //时间类型的对应策略
        globalConfig.setDateType(DateType.ONLY_DATE);
        //代码生成器的全局配置
        mpg.setGlobalConfig(globalConfig);
        /**
         * 数据源配置
         * */
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://127.0.0.1:3306/mysql?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai");
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("root1234");
        //代码生成器数据源配置
        mpg.setDataSource(dataSourceConfig);
        /**
         * 包配置
         * */
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.generator");
        packageConfig.setEntity("domain");
        packageConfig.setMapper("mapper");
        packageConfig.setXml("mapper");
        packageConfig.setController(null);
        packageConfig.setService(null);
        packageConfig.setServiceImpl(null);
        //代码生成器包配置
        mpg.setPackageInfo(packageConfig);
        /**
         * 策略配置
         * */
        StrategyConfig strategyConfig = new StrategyConfig();
        //数据库表映射到实体的命名策略(表名与实体名对应)
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        //数据库表字段映射到实体的命名策略(表字段与实体类属性名对应)
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        //实体类是否为lombok模型
        strategyConfig.setEntityLombokModel(true);
        //是否生成要@RestController控制器
        strategyConfig.setRestControllerStyle(false);
        //修改替换成你需要的表名
        strategyConfig.setInclude(scanner("表名"));
        //驼峰转连字符 todo 待验
        strategyConfig.setControllerMappingHyphenStyle(true);
        //表前缀
        strategyConfig.setTablePrefix(packageConfig.getModuleName() + "-");
        //代码生成器配置生成策略
        mpg.setStrategy(strategyConfig);
        //需要排除的表名
        mpg.execute();


    }

    public static String scanner(String tableName) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("请输入" + tableName + ":");
        System.out.println(stringBuilder.toString());
        if (scanner.hasNext()) {
            String next = scanner.next();
            if (Strings.isNotEmpty(next)) {
                return next;
            }
        }
        throw new MybatisPlusException("请输入正确的"+tableName+"!");
    }
}
