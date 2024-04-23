package com.leyou.util;

import com.leyou.constants.FileConstants;
import com.leyou.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class FileUtils {

 /*   @Autowired
    private Configuration configuration;*/

    /**
     * 读取项目里的文件内容
     *
     * @param classPathFileName 文件路径
     * @return
     */
    public static List<String> getFileContentList(String classPathFileName) {
        List<String> lineList = new ArrayList<>();
        ClassPathResource resource = new ClassPathResource(classPathFileName);
        try (InputStream inputStream = resource.getInputStream();) {
            InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(reader);
            String str;
            while ((str = br.readLine()) != null) {
                lineList.add(str);
            }
        } catch (Exception e) {
            log.error("读取文件内容异常,文件路径:{},异常原因:{}", classPathFileName, e);
            throw new BizException("读取文件内容出现异常");
        }
        return lineList;
    }

    /**
     * 导出文件内容
     *
     * @param response
     * @param content  文件内容
     * @param fileName 文件名
     */
    public static void exportFileContent(HttpServletResponse response, String content, String fileName) throws IOException {
        // 导出文件名
        String name = fileName + FileConstants.FILE_SUFFIX;
        // 设置文件编码格式
        response.setContentType(FileConstants.CHARSET);
        // 设置请求头
        response.setHeader(FileConstants.HEADER_NAME, FileConstants.HEADER_VALUE
                + new String(fileName.getBytes(), StandardCharsets.UTF_8));
        byte[] bytes = content.getBytes(StandardCharsets.UTF_8);
        try (ServletOutputStream outputStream = response.getOutputStream()) {
            outputStream.write(bytes);
        } catch (IOException e) {
            log.error("下载文件失败,失败原因:{}", e);
        }
    }

    /**
     * html模板内容转为字符串内容
     *
     * @param templatePath 模板路径
     * @param templateName 模板名称
     * @param model        数据模型
     * @return public static String templateToStr(String templatePath, String templateName, Object model) {
    try {
    //TODO 未导入 spring-boot-starter-template jar包
    configuration.setClassLoaderForTemplateLoading(this.getClass().getClassLoader(), templatePath);
    Template template = configuration.getTemplate(templateName);
    return FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
    } catch (IOException | TemPlateException e) {
    log.error("模板内容转成字符内容出错,原因:templatePath{},templateName:{},model:{}", templatePath, templateName, model);
    throw new BizException("模板内容转成字符内容出错");
    }
    }*/

/*    *//**
     * 读取本地文件
     *
     * @param filePath 本地文件路径
     * @return
     *//*
    public static String readerLocalFile(String filePath) {
        // todo 待定
        return null;
    }*/

}
