package com.excel.controller;

import com.excel.pojo.User;
import com.excel.service.ExcelService;
import com.excel.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Excel 相关操作
 */
@RestController
@RequestMapping("/excel")
public class ExcelController {

    @Autowired
    private UserService userService;

    @Autowired
    private ExcelService excelService;

    /**
     * 获取分页用户信息
     *
     * @return
     */
    @GetMapping(value = "/findPage")
    public List<User> findPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "10") Integer pageSize) {
        return userService.findPage(page, pageSize);
    }

    /**
     * excel poi 导出
     */
    @GetMapping(value = "/export")
    public void export(HttpServletResponse response) {
        excelService.export(response);
    }

    /**
     * excel poi 导入
     */
    @PostMapping(value = "/import")
    public void excelImport(@RequestParam(value = "file") MultipartFile file) {
        excelService.excelImport(file);
    }

    /**
     * 导出多个sheet页
     *
     * @param response
     */
    @GetMapping(value = "/export/more/sheet")
    public void exportMoreSheet(HttpServletResponse response) {
        excelService.exportMoreSheet(response);
    }


    /**
     * excel poi 导出百万数据
     *
     * @param response
     */
    @GetMapping(value = "/exportMillion")
    public void exportMillion(HttpServletResponse response) {
        excelService.exportMillion(response);
    }

    /**
     * excel poi 导入百万数据
     */
    @PostMapping(value = "/importMillion")
    public void importMillion(@RequestBody MultipartFile file) {
        excelService.importMillion(file);
    }

    /**
     * excel poi 使用csv文件导出百万数据
     *
     * @param response
     */
    @GetMapping(value = "/exportCSV")
    public void exportCSV(HttpServletResponse response) {
        excelService.exportCSV(response);
    }

    /**
     * excel poi 使用csv文件导入百万数据
     */
    @PostMapping(value = "/importCSV")
    public void importCSV(@RequestBody MultipartFile file) {
        excelService.importCSV(file);
    }

    /**
     * excel poi 下载用户的合同文档
     */
    @GetMapping(value = "/exportContract")
    public void exportContract(Long id, HttpServletResponse response) {
        excelService.exportContract(id, response);
    }

    /**
     * excel poi 导出用户数据到PDF中
     */
    @GetMapping(value = "/exportPDF")
    public void exportPDF(HttpServletResponse response) {
        excelService.exportPDF(response);
    }


    /*************************easy poi***************************************/

    /**
     * 使用easyPOI导出
     *
     * @param response
     */
    @GetMapping(value = "/easyPoi/export")
    public void easyPoiExport(HttpServletResponse response) {
        excelService.easyPoiExport(response);
    }

    /**
     * 使用easyPOI导入
     *
     * @param file
     */
    @PostMapping("/easyPoi/import")
    public void easyPoiImport(@RequestBody MultipartFile file) {
        excelService.easyPoiImport(file);
    }

    /**
     * 使用easyPOI模板导出
     *
     * @param response
     */
    @GetMapping("/easyPoi/export/timplate")
    public void easyPoiExportTimplate(HttpServletResponse response) {
        excelService.easyPoiExportTimplate(response);
    }

    /**
     * 使用easyPOI导出CSV文件
     *
     * @param response
     */
    @GetMapping("/easyPoi/export/CSV")
    public void easyPoiExportCSV(HttpServletResponse response) {
        excelService.easyPoiExportCSV(response);
    }

    /**
     * 使用easyPOI导出word文件
     *
     * @param response
     */
    @GetMapping("/easyPoi/export/word")
    public void easyPoiExportWord(HttpServletResponse response) {
        excelService.easyPoiExportWord(response);
    }

    // todo 导出word和pdf,图表
}
