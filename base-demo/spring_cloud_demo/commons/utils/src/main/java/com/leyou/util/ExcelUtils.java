package com.leyou.util;

import com.leyou.constants.ExcelTitleConstants;
import com.leyou.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.poi.ss.usermodel.CellType.*;

/**
 * excel 工具类
 */
@Slf4j
public class ExcelUtils {
    public static final Logger logger = LoggerFactory.getLogger(ExcelUtils.class);

    /**
     * 将工作薄写入excel
     *
     * @param response 返回体
     * @param fileName 文件名
     * @param workbook 工作薄
     */
    public static void export(HttpServletResponse response, Workbook workbook, String fileName) {
        try {
            String value = "attachment;filename=" + new String(fileName.getBytes(StandardCharsets.UTF_8), "iso8859-1");
            response.setHeader("Content-Disposition", value);
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            BufferedOutputStream bufferedOutPut = new BufferedOutputStream(response.getOutputStream());
            workbook.write(bufferedOutPut);
            bufferedOutPut.flush();
            bufferedOutPut.close();
        } catch (UnsupportedEncodingException e) {
            log.error("导出" + fileName + "文件错误，错误信息：{}", e);
        } catch (IOException e) {
            log.error("导出" + fileName + "文件IO错误，错误信息：{}", e);
        }
    }

    /**
     * 插入 图片
     *
     * @param wb        工作薄
     * @param sheet     sheet页
     * @param rootFile  根目录
     * @param photo     图片的相对路径
     * @param rowIndex  行数
     * @param cellIndex 列数
     */
    public static void handlePhoto(Workbook wb, Sheet sheet, File rootFile, String photo, int rowIndex, int cellIndex) {
        try {
            //        照片的位置
//        开始处理照片
//        先创建一个字节输出流
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        读取图片 放入了一个带有缓存区的图片类中
            BufferedImage bufferedImage = ImageIO.read(new File(rootFile, photo));
//       把图片写入到了字节输出流中
            String extName = photo.substring(photo.lastIndexOf(".") + 1).toUpperCase();
            ImageIO.write(bufferedImage, extName, byteArrayOutputStream);
//        Patriarch 控制图片的写入 和ClientAnchor 指定图片的位置
            Drawing patriarch = sheet.createDrawingPatriarch();
//        指定图片的位置         开始列3 开始行2   结束列4  结束行5  (这4个参数不可以重复)
//        偏移的单位：是一个英式公制的单位  1厘米=360000
            ClientAnchor anchor = new XSSFClientAnchor(0, 0, 0, 0, cellIndex, rowIndex, cellIndex + 1, rowIndex + 1);
//        开始把图片写入到sheet指定的位置
            int format = 0;
            switch (extName) {
                case "JPG": {
                    format = XSSFWorkbook.PICTURE_TYPE_JPEG;
                }
                case "JPEG": {
                    format = XSSFWorkbook.PICTURE_TYPE_JPEG;
                }
                case "PNG": {
                    format = XSSFWorkbook.PICTURE_TYPE_PNG;
                }
            }
            patriarch.createPicture(anchor, wb.addPicture(byteArrayOutputStream.toByteArray(), format));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 自定义列宽
     *
     * @param sheet
     * @param colNum
     * @return
     */
    public static int getAutoColWidth(Sheet sheet, int colNum) {
        int maxColumnWidth = 30 * 256;
        int columnWidth = sheet.getColumnWidth(colNum);
        if (columnWidth > maxColumnWidth) {
            columnWidth = maxColumnWidth;
        }
        return columnWidth * 12 / 10;
    }

    /**
     * 表头样式
     *
     * @param workbook
     * @return
     */
    public static CellStyle titleStyle(Workbook workbook) {
        CellStyle cellStyle = workbook.createCellStyle();
        //水平居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);
        Font font = workbook.createFont();
        font.setBold(true);
        cellStyle.setFont(font);
        return cellStyle;
    }

    /**
     * 根据列的类型获取对应的内容
     *
     * @param cell
     * @return
     */
    public static String getValue(Cell cell, FormulaEvaluator evaluator) {
        String cellValue = "";
        if (null == cell) {
            return cellValue;
        }
        CellType type = cell.getCellTypeEnum();
        switch (type) {
            case NUMERIC:
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    // 日期
                    Date value = cell.getDateCellValue();
                    cellValue = DateUtils.dateToString(value, DateUtils.FORMAT_YYYY_MM_DD_HH_MM_SS);
                } else {
                    // 不是日期
                    cell.setCellType(NUMERIC);
                    cellValue = cell.toString();
                    cellValue = BigDecimalUtil.numberRemoveZero(cellValue);
                }
                break;
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            case BOOLEAN:
                cellValue = cell.getBooleanCellValue() + "";
                break;
            case FORMULA:
                CellValue evaluate = evaluator.evaluate(cell);
                cellValue = evaluate.formatAsString();
                break;
            case BLANK:
                cellValue = "";
                break;
            case _NONE:
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }

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
     * 构造普通样式
     *
     * @param workbook 工作薄
     * @return
     */
    private static HSSFCellStyle commonStyle(HSSFWorkbook workbook) {
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

    /**
     * 标题样式
     *
     * @param workbook 工作薄
     * @return
     */
    private static HSSFCellStyle titleStyle(HSSFWorkbook workbook) {

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
     * 构造样式
     *
     * @param workbook 工作薄
     * @return
     */
    public static Map<String, HSSFCellStyle> tectonicStyle(HSSFWorkbook workbook) {
        Map<String, HSSFCellStyle> styleMap = new HashMap<>();
        // 普通样式
        HSSFCellStyle commonStyle = commonStyle(workbook);
        // 标题样式
        HSSFCellStyle titleStyle = titleStyle(workbook);
        styleMap.put(ExcelTitleConstants.COMMON_STYLE, commonStyle);
        styleMap.put(ExcelTitleConstants.TITLE_STYLE, titleStyle);
        return styleMap;
    }
}
