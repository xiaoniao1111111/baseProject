package com.noah.util;

import com.noah.domain.TbUser;
import com.noah.exception.BizException;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Excel导入工具类
 *
 * @Author: WangXinWei
 * @Date: 2019/12/20 17:10
 * @Version 1.0
 */
public class ExcelImportUtils {
    /**
     * Excel 2003
     */
    private static final String XLS = "xls";
    /**
     * Excel 2007
     */
    private static final String XLSX = "xlsx";

    /**
     * 由Excel流的sheet导出至list
     *
     * @param file     文件路径
     * @param sheetNum sheet页
     * @return
     * @throws IOException
     */
    public static List<TbUser> exportListFromExcel(File file, int sheetNum) throws IOException {
        // 将文件读入到内存中
        InputStream fileInputStream = new FileInputStream(file);
        // 获取该文件的后缀名
        String extension = FilenameUtils.getExtension(file.getName());
        return exportListFromExcel(fileInputStream, extension, sheetNum);
    }

    /**
     * 获取工作薄
     *
     * @param fileInputStream 流
     * @param extension       后缀名
     * @param sheetNum        sheet页
     * @return
     */
    private static List<TbUser> exportListFromExcel(InputStream fileInputStream, String extension, int sheetNum) throws IOException {

        Workbook workbook = null;
        if (extension.toLowerCase().equals(XLS)) {
            workbook = new HSSFWorkbook(fileInputStream);
        } else if (extension.toLowerCase().equals(XLSX)) {
            workbook = new XSSFWorkbook(fileInputStream);
        } else {
            throw new BizException("文件格式错误");
        }
        return exportListFromExcel(workbook, sheetNum);
    }

    /**
     * 获取数据集合
     *
     * @param workbook 工作薄
     * @param sheetNum sheet页
     * @return
     */
    private static List<TbUser> exportListFromExcel(Workbook workbook, int sheetNum) {
        List<TbUser> tbUsers = new ArrayList<>();
        Sheet sheet = workbook.getSheetAt(sheetNum);
        // 获取所有的行
        int lastRowNum = sheet.getLastRowNum();
        // 开始组装数据---(这里的索引i 要看有多少行标题,如果只有1行就是1,如果2行那就是2,我们需要数据行)
        for (int rowNum = 2; rowNum < lastRowNum; rowNum++) {
            TbUser tbUser = new TbUser();
            // 获取行
            Row row = sheet.getRow(rowNum);
            // 组装用户名
            tbUser.setUserName(row.getCell(0).getStringCellValue());
            // 组装密码
            tbUser.setPassword(row.getCell(1).getStringCellValue());
            // 组装姓名
            tbUser.setName(row.getCell(2).getStringCellValue());
            // 组装年龄
            tbUser.setAge(StringUtils.isEmpty(row.getCell(3).getStringCellValue()) ?
                    null : Integer.valueOf(row.getCell(3).getStringCellValue()));
            // 组装性别
            tbUser.setSex("男".equals(row.getCell(4).getStringCellValue()));
            // 组装出生日期
            tbUser.setBirthday(DateUtils.stringToDate(row.getCell(5).getStringCellValue()));
            // 组装创建时间
            tbUser.setCreated(DateUtils.stringToDate(row.getCell(6).getStringCellValue()));
            // 组装更新时间
            tbUser.setUpdated(DateUtils.stringToDate(row.getCell(7).getStringCellValue()));
            tbUsers.add(tbUser);
        }
        return tbUsers;
    }
}
