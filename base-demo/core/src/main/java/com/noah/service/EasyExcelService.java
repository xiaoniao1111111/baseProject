package com.noah.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author: WangXinWei
 * @Date: 2019/7/5 9:16
 * @Version 1.0
 */
public interface EasyExcelService {
    void downLoad(HttpServletResponse response);

    /**
     * 导入
     *
     * @param file
     */
    void excelImport(MultipartFile file);
}
