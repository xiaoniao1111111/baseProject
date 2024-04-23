package com.noah.util;

import com.noah.constants.ExcelTitleConstants;
import com.noah.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * Excel导出工具类
 * @Author: WangXinWei
 * @Date: 2019/12/20 9:33
 * @Version 1.0
 */
@Slf4j
public class ExcelExportUtils {

    /**
     * excel导出多个sheet页
     *
     * @param wb         工作薄
     * @param sheetNames sheet页名称
     * @param titles     标题
     * @param dataList   数据源
     * @param styleMap   样式
     * @return
     * @throws Exception 异常类
     */
    public static HSSFWorkbook exportMoreSheet(HSSFWorkbook wb, String[] sheetNames, List<String[]> titles,
                                               List<List> dataList, Map<String, HSSFCellStyle> styleMap) {


        // 新建sheet
        HSSFSheet sheet = null;
        int index = 0;
        while (index < sheetNames.length) {
            // 标题数组
            String[] eachGroupTitle = titles.get(index);
            String[] titleArray = new String[eachGroupTitle.length];
            // 字段名数组
            String[] fieldArray = new String[eachGroupTitle.length];
            // 组装标题数组和字段名数组
            for (int i = 0; i < eachGroupTitle.length; i++) {
                // 分隔标题和字段名
                String[] titleAndFieldSplit = eachGroupTitle[i].split("#");
                titleArray[i] = titleAndFieldSplit[0];
                fieldArray[i] = titleAndFieldSplit[1];
            }

            // 设置新建sheet名称
            sheet = wb.createSheet(sheetNames[index]);

            // 首行标题行
            HSSFRow row = sheet.createRow(0);
            // 为标题行赋值
            for (int i = 0; i < titleArray.length; i++) {
                // 设置列
                HSSFCell cell = row.createCell(i);
                cell.setCellStyle(styleMap.get(ExcelTitleConstants.TITLE_STYLE));
                cell.setCellValue(titleArray[i]);
                // 自动设置宽度
                sheet.autoSizeColumn(i);
            }

            // 填充数据
            List list = dataList.get(index);
            fillingDataSource(sheet, styleMap, fieldArray, list);

            index++;
        }

        return wb;
    }

    /**
     * 填充数据
     *
     * @param sheet      sheet页
     * @param styleMap   样式
     * @param fieldArray 字段名数组
     * @param list       数据源
     */
    private static void fillingDataSource(HSSFSheet sheet, Map<String, HSSFCellStyle> styleMap,
                                          String[] fieldArray, List list) {

        if (!CollectionUtils.isEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                HSSFRow row = sheet.createRow(i + 1);
                // 如果最里层List的泛型对象是Map,那么这是一个List<List<Map<String,Object>>>集合
                if (list.get(i) instanceof Map) {
                    for (int j = 0; j < fieldArray.length; j++) {
                        HSSFCell cell = row.createCell(j);
                        cell.setCellStyle(styleMap.get(ExcelTitleConstants.COMMON_STYLE));
                        Map map = (Map) list.get(i);
                        if (null != map) {
                            cell.setCellValue(StringUtils.isEmpty(map.get(fieldArray[j])) ? "" : map.get(fieldArray[j]).toString());
                        }
                    }
                    // 如果List最里层是对象,则通过反射获取值
                } else if (list.get(i) != null) {
                    for (int x = 0; x < fieldArray.length; x++) {
                        HSSFCell cell = row.createCell(x);
                        cell.setCellStyle(styleMap.get(ExcelTitleConstants.COMMON_STYLE));
                        // 利用反射,根据传过来的字段名,动态调用对象的getXxx()方法得到属性值
                        String methodName = "get" + fieldArray[x].substring(0, 1).toUpperCase() + fieldArray[x].substring(1);
                        try {
                            Method method = list.get(i).getClass().getMethod(methodName);
                            Object value = method.invoke(list.get(i));
                            cell.setCellValue(value.toString());
                        } catch (Exception e) {
                            throw new BizException("获取属性值异常", e);
                        }
                    }
                }
            }
        }

    }

    /**
     * 将工作薄写入excel
     *
     * @param response         返回体
     * @param fileName         文件名
     * @param workbook         工作薄
     * @param exceptionMessage 自定义异常信息
     */
    public static void writeExcel(HttpServletResponse response, String fileName, Workbook workbook, String exceptionMessage) {
        // 设置编码格式
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        try {
            response.setHeader("Content-Disposition", "attachment;filename="
                    + URLEncoder.encode(fileName + ".xls", "utf-8"));
        } catch (UnsupportedEncodingException e) {
            log.error("不支持的编码", e);
        }

        // 将工作薄写入流中
        try (ServletOutputStream outputStream = response.getOutputStream()) {
            workbook.write(outputStream);
        } catch (IOException e) {
            log.error("生成" + exceptionMessage + "Excel出现异常", e);
            throw new BizException("生成" + exceptionMessage + "Excel出现异常");
        }
    }

}
