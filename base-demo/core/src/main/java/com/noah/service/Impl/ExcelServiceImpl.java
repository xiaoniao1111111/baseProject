package com.noah.service.Impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.alibaba.fastjson.JSON;
import com.noah.constants.ExcelTitleConstants;
import com.noah.domain.Company;
import com.noah.domain.TbItem;
import com.noah.domain.TbUser;
import com.noah.exception.BizException;
import com.noah.pojo.UserInfoExcel;
import com.noah.resp.*;
import com.noah.service.ICompanyService;
import com.noah.service.IExcelService;
import com.noah.service.IItemService;
import com.noah.service.ITbUserService;
import com.noah.util.DateUtils;
import com.noah.util.ExcelExportUtils;
import com.noah.util.ExcelImportUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.noah.util.ExcelExportUtils.exportMoreSheet;

/**
 * @Author: WangXinWei
 * @Date: 2019/7/5 9:26
 * @Version 1.0
 */
@Service
@Slf4j
public class ExcelServiceImpl implements IExcelService {

    @Autowired
    private ITbUserService tbUserService;
    @Autowired
    private ICompanyService companyService;
    @Autowired
    private IItemService iItemService;

    /**
     * user信息excel导出
     *
     * @return
     */
    @Override
    public void userInfoExcelDownload(HttpServletResponse response) {

        // 获取全量的user信息
        List<TbUser> tbUsers = tbUserService.listTbUser();
        log.info("获取到的用户信息: ", JSON.toJSONString(tbUsers));
        List<UserResp> userResps = new ArrayList<>();
        tbUsers.forEach(tbUser -> {
            UserResp userResp = new UserResp();
            BeanUtils.copyProperties(tbUser, userResp);
            userResps.add(userResp);
        });

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("目标客户", "客户"), UserResp.class, userResps);
        excelCreate(workbook, response);
    }

    /**
     * 公司图片导出
     *
     * @param response
     */
    @Override
    public void companyImageExcelDownload(HttpServletResponse response) {
        List<Company> companies = companyService.listCompany();
        List<CompanyResp> companyResps = new ArrayList<>();
        companies.forEach(company -> {
            CompanyResp companyResp = new CompanyResp();
            BeanUtils.copyProperties(company, companyResp);
            companyResps.add(companyResp);
        });
        Workbook workbook = ExcelExportUtil.exportBigExcel(new ExportParams("公司信息", "公司名"),
                CompanyResp.class, companyResps);
        excelCreate(workbook, response);
    }

    /**
     * user信息Excel导入
     */
    @Override
    public void userInfoExcelInsert() {

        File file = new File("D:\\image\\signing.xls");
        ImportParams importParams = new ImportParams();
        importParams.setTitleRows(1);
        importParams.setReadRows(8);
        List<Object> objects = listExcelInsert(file, UserInsertResq.class, importParams);
        List<UserInsertResq> collect = objects.stream().map(item -> (UserInsertResq) item).collect(Collectors.toList());
        log.info("获取到的信息:", collect);
        System.out.println("获取到的信息 : " + collect);
    }

    /**
     * 融合用户、公司、主题 导出
     *
     * @param response
     */
    @Override
    public void listFusionDownload(HttpServletResponse response) {

        // 获取融合集合
        //List<FusionListResp> fusionListResps = queryFusionDownloadList();
       List<FusionListResp> fusionListResps = new ArrayList<>();
        for (int i = 0; i < 150000; i++) {
            FusionListResp fusionListResp = new FusionListResp();
            fusionListResp.setAge(1);
            fusionListResp.setName("hello");
            fusionListResp.setSex(false);
            fusionListResps.add(fusionListResp);
        }

        // 导出融合数据
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("公司信息", "公司名"),
                FusionListResp.class, fusionListResps);
        excelCreate(workbook, response);
    }

    /**
     * 图片导入
     *
     * @param response
     */
    @Override
    public void companyImageExcelInsert(HttpServletResponse response) {

        File file = new File("D:\\image\\company.xls");
        ImportParams importParams = new ImportParams();
        importParams.setTitleRows(1);
        importParams.setReadRows(8);
        List<Object> objects = listExcelInsert(file, CompanyInsertResp.class, importParams);
        List<CompanyInsertResp> collect = objects.stream().map(item -> (CompanyInsertResp) item).collect(Collectors.toList());
        log.info("获取到的信息:", collect);
        System.out.println("获取到的信息 : " + collect);
    }

    @Override
    public void userInfoExcelDownloadWayTwo(HttpServletResponse response) {

        // 获取全量的user信息
        List<TbUser> tbUsers = tbUserService.listTbUser();
        if (CollectionUtils.isEmpty(tbUsers)) {
            throw new BizException("用户信息不可为空");
        }
        tbUsersExcel(response, tbUsers);
    }

    @Override
    public void usersAndCompanyExcelDownload(HttpServletResponse response) {
        // 创建工作薄
        HSSFWorkbook wb = new HSSFWorkbook();
        // 构造样式
        Map<String, HSSFCellStyle> styleMap = tectonicStyle(wb);
        // 组装sheet名称
        String[] sheetNames = new String[]{"用户信息明细导出", "公司信息明细导出"};
        // 组装用户和公司标题名及字段名
        List<String[]> titles = assembleUserAndCompanyTitleAndFiled();
        // 组装用户信息和公司信息
        List<List> dataList = assembleUserAndCompanyInfo();
        // 用户信息和公司信息Excle导出
        HSSFWorkbook workbook = exportMoreSheet(wb, sheetNames, titles, dataList, styleMap);
        // 设置Excel名称
        String fileName = "用户信息明细和公司信息明细导出";
        // 自定义异常信息
        String exceptionMessage = "用户信息明细和公司信息明细";
        // 将工作薄写入excel中
        ExcelExportUtils.writeExcel(response, fileName, workbook, exceptionMessage);
    }

    @Override
    public List<TbUser> userInfoExcelImport() {
        List<TbUser> tbUsers = new ArrayList<>();
        File file = new File("D:\\excel\\users.xls");
        try {
            tbUsers = ExcelImportUtils.exportListFromExcel(file, 0);
        } catch (IOException e) {
            throw new BizException("用户信息导入异常");
        }
        return tbUsers;
    }


    /**
     * 组装用户信息和公司信息
     *
     * @return
     */
    private List<List> assembleUserAndCompanyInfo() {
        List<List> dataList = new ArrayList<>();
        // 获取用户全量信息
        List<TbUser> tbUsers = tbUserService.listTbUser();
        List<UserInfoExcel> userInfoExcels = new ArrayList<>();
        tbUsers.forEach(tbUser -> {
            UserInfoExcel userInfoExcel = new UserInfoExcel();
            BeanUtils.copyProperties(tbUser, userInfoExcel);
            userInfoExcel.setBirthday(DateUtils.dateToString(tbUser.getBirthday(), DateUtils.DATE_FORMAT));
        });
        // 获取公司全量信息
        List<Company> companies = companyService.listCompany();
        dataList.add(userInfoExcels);
        dataList.add(companies);
        return dataList;
    }

    /**
     * 组装用户和公司标题名及字段名
     *
     * @return
     */
    private List<String[]> assembleUserAndCompanyTitleAndFiled() {
        List<String[]> titles = new ArrayList<>();
        // 用户信息标题和字段名
        String[] userTitles = new String[]{"用户名#userName", "密码#password",
                "姓名#name", "年龄#age", "性别#sex", "出生日期#birthday"};
        // 公司信息标题和字段名
        String[] companys = new String[]{"公司名#companyName", "图片链接#image", "公司地址#address"};
        titles.add(userTitles);
        titles.add(companys);
        return titles;
    }

    private void tbUsersExcel(HttpServletResponse response, List<TbUser> tbUsers) {

        // 设置文件名
        String fileName = "用户信息导出";
        // 组装用户信息导出工作薄
        Workbook tbUsersWorkBook = createTbUsersWorkBook(tbUsers);
        // 自定义异常信息
        String exception = "用户信息";
        // 将工作薄写入excel中
        ExcelExportUtils.writeExcel(response, fileName, tbUsersWorkBook, exception);

    }

    /**
     * 组装用户信息导出工作薄
     *
     * @param tbUsers 用户信息
     * @return
     */
    private Workbook createTbUsersWorkBook(List<TbUser> tbUsers) {

        // 创建工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();

        // 构造样式（设置标题样式，数据样式，特殊样式）
        Map<String, HSSFCellStyle> styleMap = tectonicStyle(workbook);

        // sheet页名称并创建sheet页
        String sheetName = "用户信息导出明细";
        HSSFSheet sheet = workbook.createSheet(sheetName);

        // 设置列宽
        sheet.setDefaultColumnWidth(26);
        // 设置行高
        sheet.setDefaultRowHeight((short) 320);

        // 填充sheet内容
        editSheetTbUsersContent(sheet, tbUsers, styleMap);

        return workbook;
    }

    /**
     * 填充sheet内容
     *
     * @param sheet    sheet页
     * @param tbUsers  用户信息
     * @param styleMap 构造样式
     */
    private void editSheetTbUsersContent(HSSFSheet sheet, List<TbUser> tbUsers, Map<String, HSSFCellStyle> styleMap) {

        // 设置首行标题
        setFirstRowTitle(sheet, styleMap, tbUsers);

        // 设置内容
        setTbUsersContent(sheet, tbUsers, styleMap);

    }

    /**
     * 设置内容
     *
     * @param sheet    sheet页
     * @param tbUsers  用户信息集合
     * @param styleMap 构造样式
     */
    private void setTbUsersContent(HSSFSheet sheet, List<TbUser> tbUsers, Map<String, HSSFCellStyle> styleMap) {

        for (int i = 0; i < tbUsers.size(); i++) {
            HSSFRow row = sheet.createRow(i + 1);
            // 用户名
            HSSFCell cell = row.createCell(0);
            cell.setCellValue(tbUsers.get(i).getUserName());
            cell.setCellStyle(styleMap.get(ExcelTitleConstants.COMMON_STYLE));

            // 密码
            HSSFCell cell1 = row.createCell(1);
            cell1.setCellValue(tbUsers.get(i).getPassword());
            cell1.setCellStyle(styleMap.get(ExcelTitleConstants.COMMON_STYLE));

            // 姓名
            HSSFCell cell2 = row.createCell(2);
            cell2.setCellValue(tbUsers.get(i).getName());
            cell2.setCellStyle(styleMap.get(ExcelTitleConstants.COMMON_STYLE));

            // 年龄
            HSSFCell cell3 = row.createCell(3);
            cell3.setCellValue(tbUsers.get(i).getAge());
            cell3.setCellStyle(styleMap.get(ExcelTitleConstants.COMMON_STYLE));

            // 性别
            HSSFCell cell4 = row.createCell(4);
            cell4.setCellValue(tbUsers.get(i).getSex());
            cell4.setCellStyle(styleMap.get(ExcelTitleConstants.COMMON_STYLE));

            // 出生日期
            HSSFCell cell5 = row.createCell(5);
            cell5.setCellValue(tbUsers.get(i).getBirthday());
            cell5.setCellStyle(styleMap.get(ExcelTitleConstants.COMMON_STYLE));

        }

    }

    /**
     * 设置首行标题
     *
     * @param sheet    sheet页
     * @param styleMap 构造样式
     * @param tbUsers  用户信息集合
     */
    private void setFirstRowTitle(HSSFSheet sheet, Map<String, HSSFCellStyle> styleMap, List<TbUser> tbUsers) {
        HSSFCellStyle commonStype = styleMap.get(ExcelTitleConstants.COMMON_STYLE);
        /*// 合并单元格：
        CellRangeAddress region = new CellRangeAddress(1, 1, 1, 2);
        sheet.addMergedRegion(region);*/

        HSSFRow firstRow = sheet.createRow(0);
        // 标题: 用户名
        HSSFCell cell = firstRow.createCell(0);
        cell.setCellStyle(commonStype);
        cell.setCellValue("用户名");

        // 标题: 密码
        HSSFCell cell1 = firstRow.createCell(1);
        cell1.setCellStyle(commonStype);
        cell1.setCellValue("密码");

        // 标题: 姓名
        HSSFCell cell2 = firstRow.createCell(2);
        cell2.setCellStyle(commonStype);
        cell2.setCellValue("姓名");

        // 标题:  年龄
        HSSFCell cell3 = firstRow.createCell(3);
        cell3.setCellStyle(commonStype);
        cell3.setCellValue("年龄");

        // 标题:  性别
        HSSFCell cell4 = firstRow.createCell(4);
        cell4.setCellStyle(commonStype);
        cell4.setCellValue("性别");

        // 标题:  出生日期
        HSSFCell cell5 = firstRow.createCell(5);
        cell5.setCellStyle(commonStype);
        cell5.setCellValue("出生日期");

    }

    /**
     * 构造样式
     *
     * @param workbook 工作薄
     * @return
     */
    private Map<String, HSSFCellStyle> tectonicStyle(HSSFWorkbook workbook) {
        Map<String, HSSFCellStyle> styleMap = new HashMap<>();
        // 普通样式
        HSSFCellStyle commonStyle = commonStyle(workbook);
        // 标题样式
        HSSFCellStyle titleStyle = titleStyle(workbook);
        styleMap.put(ExcelTitleConstants.COMMON_STYLE, commonStyle);
        styleMap.put(ExcelTitleConstants.TITLE_STYLE, titleStyle);
        return styleMap;
    }

    /**
     * 标题样式
     *
     * @param workbook 工作薄
     * @return
     */
    private HSSFCellStyle titleStyle(HSSFWorkbook workbook) {

        // 创建样式
        HSSFCellStyle cellStyle = workbook.createCellStyle();

        // 设置数据边框 ->底部
        cellStyle.setBorderBottom(BorderStyle.THIN);
        // 顶部
        cellStyle.setBorderTop(BorderStyle.THIN);
        // 左边
        cellStyle.setBorderLeft(BorderStyle.THIN);
        // 右边
        cellStyle.setBorderRight(BorderStyle.THIN);

        // 设置边框颜色
        cellStyle.setBottomBorderColor(IndexedColors.BLACK.index);
        cellStyle.setTopBorderColor(IndexedColors.BLACK.index);
        cellStyle.setLeftBorderColor(IndexedColors.BLACK.index);
        cellStyle.setRightBorderColor(IndexedColors.BLACK.index);

        // 设置居中样式(水平居中)
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        // 竖直居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        // 设置前景色
        cellStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
        // 设置填充规则
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // 创建字体
        HSSFFont font = workbook.createFont();
        // 设置字体类型
        font.setFontName("宋体");
        // 设置字体是否加粗
        font.setBold(true);
        // 设置字体是否倾斜
        font.setItalic(false);
        // 设置字号
        font.setFontHeightInPoints((short) 13);
        // 设置字体颜色
        font.setColor(IndexedColors.BLACK.index);
        // 将字体加入样式
        cellStyle.setFont(font);
        return cellStyle;
    }

    /**
     * 构造普通样式
     *
     * @param workbook 工作薄
     * @return
     */
    private HSSFCellStyle commonStyle(HSSFWorkbook workbook) {
        // 创建样式
        HSSFCellStyle cellStyle = workbook.createCellStyle();

        // 设置数据边框 ->底部
        cellStyle.setBorderBottom(BorderStyle.THIN);
        // 顶部
        cellStyle.setBorderTop(BorderStyle.THIN);
        // 左边
        cellStyle.setBorderLeft(BorderStyle.THIN);
        // 右边
        cellStyle.setBorderRight(BorderStyle.THIN);

        // 设置边框颜色
        cellStyle.setBottomBorderColor(IndexedColors.BLUE.index);
        cellStyle.setTopBorderColor(IndexedColors.RED.index);
        cellStyle.setLeftBorderColor(IndexedColors.GREEN.index);
        cellStyle.setRightBorderColor(IndexedColors.ORANGE.index);

        // 设置居中样式(水平居中)
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        // 竖直居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        // 设置前景色
        // cellStyle.setFillForegroundColor(IndexedColors.SKY_BLUE.index);
        // 设置填充规则
        //cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // 创建字体
        HSSFFont font = workbook.createFont();
        // 设置字体类型
        font.setFontName("宋体");
        // 设置字体是否加粗
        font.setBold(true);
        // 设置字体是否倾斜
        font.setItalic(false);
        // 设置字号
        font.setFontHeightInPoints((short) 11);
        // 设置字体颜色
        font.setColor(IndexedColors.BLACK.index);
        // 将字体加入样式
        cellStyle.setFont(font);

        return cellStyle;
    }

    private List<Object> listExcelInsert(File file, Class c, ImportParams importParams) {

        List<Object> objects = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            objects = ExcelImportUtil.importExcel(fileInputStream, c, importParams);
        } catch (Exception e) {
            System.out.println("e = " + e);
        }
        return objects;
    }

    /**
     * 获取全量用户信息
     *
     * @return
     */
    private List<FusionListResp> queryFusionDownloadList() {

        // 获取全量的user信息
        List<TbUser> tbUsers = tbUserService.listTbUser();
        List<FusionListResp> fusionListResps = new ArrayList<>();
        if (!CollectionUtils.isEmpty(tbUsers)) {
            tbUsers.forEach(tbUser -> {
                CompanyResp companyByUserId = getCompanyByUserId(tbUser.getId());
                List<ItemResp> itemResps = listItemByUserId(tbUser.getId());
                FusionListResp fusionListResp = new FusionListResp();
                BeanUtils.copyProperties(tbUser, fusionListResp);
                fusionListResp.setCompanyResp(companyByUserId);
                fusionListResp.setItemResps(itemResps);
                fusionListResps.add(fusionListResp);
            });
        }

        return fusionListResps;
    }

    /**
     * 获取主题
     *
     * @param id
     * @return
     */
    private List<ItemResp> listItemByUserId(Long id) {

        List<TbItem> tbItems = iItemService.listItemByUserId(id);
        List<ItemResp> itemResps = new ArrayList<>();
        if (!CollectionUtils.isEmpty(tbItems)) {
            tbItems.forEach(tbItem -> {
                ItemResp itemResp = new ItemResp();
                BeanUtils.copyProperties(tbItem, itemResp);
                itemResps.add(itemResp);
            });
        }

        return itemResps;
    }

    /**
     * 获取公司信息
     *
     * @param id
     * @return
     */
    private CompanyResp getCompanyByUserId(Long id) {

        Company company = companyService.getCompanyByUserId(id);
        CompanyResp companyResp = new CompanyResp();
        if (null != company) {
            BeanUtils.copyProperties(company, companyResp);
        }
        return companyResp;
    }

    public void excelCreate(Workbook workbook, HttpServletResponse response) {
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.addHeader("Content-Disposition", "attachment; filename=" + new String("signing.xlsx"));
        try {
            OutputStream outputStream = response.getOutputStream();
            workbook.write(outputStream);
        } catch (Exception e) {
            System.out.println("e = " + e);
        }
    }
}
