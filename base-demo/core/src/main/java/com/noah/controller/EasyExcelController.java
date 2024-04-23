package com.noah.controller;

import com.noah.service.EasyExcelService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@Api("EasyExcel")
@RestController
@RequestMapping("/easy/excel")
public class EasyExcelController {
    @Autowired
    private EasyExcelService easyExcelService;

    @ApiOperation("导出模板")
    @GetMapping("/downLoad")
    public void downLoad(HttpServletResponse response) {
        easyExcelService.downLoad(response);
    }

    @ApiOperation("导入模板")
    @PostMapping("/import")
    public void excelImport(@RequestBody MultipartFile file){
        easyExcelService.excelImport(file);

    }
}
