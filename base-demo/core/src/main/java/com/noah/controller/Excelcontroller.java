package com.noah.controller;


import com.noah.common.BaseResponse;
import com.noah.domain.TbUser;
import com.noah.service.IExcelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * @Author: WangXinWei
 * @Date: 2019/7/5 9:16
 * @Version 1.0
 */
@Api(value = "Excel导出",tags = {"Excel导出"})
@RestController
@Slf4j
@RequestMapping("/excel")
public class Excelcontroller {
    @Autowired
    private IExcelService excelService;

    @ApiOperation(value = "user信息Excel导出",notes = "user信息Excel导出")
    @RequestMapping(value = "/user/info/excel/download", method = RequestMethod.GET)
    public void userInfoExcelDownload(HttpServletResponse response) {
        log.info("user信息Excel导出");
        excelService.userInfoExcelDownload(response);

    }

    @ApiOperation(value = "公司图片导出",notes = "公司图片导出")
    @RequestMapping(value = "/company/image/excel/download", method = RequestMethod.GET)
    public void companyImageExcelDownload(HttpServletResponse response) {
        log.info("公司图片导出");
        excelService.companyImageExcelDownload(response);
    }

    @ApiOperation(value = "user信息Excel导入",notes = "user信息Excel导入")
    @RequestMapping(value = "/user/info/excel/insert", method = RequestMethod.GET)
    public void userInfoExcelInsert() {
        log.info("user信息Excel导入");
        excelService.userInfoExcelInsert();
    }

    @ApiOperation(value = "融合用户、公司、主题 导出",notes = "融合用户、公司、主题 导出")
    @RequestMapping(value = "/fusion/list/download", method = RequestMethod.GET)
    public void listFusionDownload(HttpServletResponse response) {
        log.info("融合用户、公司、主题 导出");
        excelService.listFusionDownload(response);
    }

    @ApiOperation(value = "图片导入",notes = "图片导入")
    @RequestMapping(value = "/company/image/excel/insert", method = RequestMethod.GET)
    public void companyImageExcelInsert(HttpServletResponse response) {
        log.info("图片导入");
        excelService.companyImageExcelInsert(response);
    }

    @ApiOperation(value = "user信息Excel导出方式二",notes = "user信息Excel导出方式二")
    @RequestMapping(value = "/user/info/excel/download/way/two", method = RequestMethod.GET)
    public void userInfoExcelDownloadWayTwo(HttpServletResponse response) {
        log.info("user信息Excel导出方式二");
        excelService.userInfoExcelDownloadWayTwo(response);

    }

    @ApiOperation(value = "Excel导出公司及用户的信息",notes = "Excel导出公司及用户的信息")
    @RequestMapping(value  ="users/Company/excel/download",method = RequestMethod.GET)
    public void usersAndCompanyExcelDownload(HttpServletResponse response){
        log.info("Excel导出公司及用户的信息");
        excelService.usersAndCompanyExcelDownload(response);
    }

    @ApiOperation(value = "用户信息导入-方式二",notes = "用户信息导入-方式二")
    @RequestMapping(value = "users/excel/import",method = RequestMethod.GET)
    public BaseResponse userInfoExcelImport(){
        log.info("用户信息excel导入");
        List<TbUser> tbUsers = excelService.userInfoExcelImport();
        return BaseResponse.success(tbUsers);
    }
}
