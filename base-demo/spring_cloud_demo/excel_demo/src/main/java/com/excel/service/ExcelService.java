package com.excel.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface ExcelService {
    /**
     * excel 简单导出
     *
     * @param response
     */
    void export(HttpServletResponse response);

    /**
     * excel 简单导入
     *
     * @param file
     */
    void excelImport(MultipartFile file);

    /**
     * 导出百万数据
     *
     * @param response
     */
    void exportMillion(HttpServletResponse response);

    /**
     * 使用csv文件导出百万数据
     *
     * @param response
     */
    void exportCSV(HttpServletResponse response);

    /**
     * 下载用户的合同文档
     *
     * @param id       用户ID
     * @param response
     */
    void exportContract(Long id, HttpServletResponse response);

    /**
     * 导出用户数据到PDF中
     *
     * @param response
     */
    void exportPDF(HttpServletResponse response);

    /**
     * 导出多个sheet页
     *
     * @param response
     */
    void exportMoreSheet(HttpServletResponse response);

    /**
     * 使用easyPOI导出
     *
     * @param response
     */
    void easyPoiExport(HttpServletResponse response);

    /**
     * 使用easyPOI导入
     *
     * @param file
     */
    void easyPoiImport(MultipartFile file);

    /**
     * 使用easyPOI模板导出
     *
     * @param response
     */
    void easyPoiExportTimplate(HttpServletResponse response);

    /**
     * 使用easyPOI导出CSV文件
     *
     * @param response
     */
    void easyPoiExportCSV(HttpServletResponse response);

    /**
     * 使用easyPOI导出word文件
     *
     * @param response
     */
    void easyPoiExportWord(HttpServletResponse response);

    /**
     * excel poi 导入百万数据
     *
     * @param file
     */
    void importMillion(MultipartFile file);

    /**
     * excel poi 使用csv文件导入百万数据
     *
     * @param file
     */
    void importCSV(MultipartFile file);
}
