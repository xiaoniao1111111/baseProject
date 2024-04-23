package com.noah.service.Impl;

import com.noah.service.EasyExcelService;
import com.noah.util.DateUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Objects;

/**
 * @Author: WangXinWei
 * @Date: 2019/7/5 9:16
 * @Version 1.0
 */
@Service
public class EasyExcelServiceImpl implements EasyExcelService {

    /**
     * 导出模板
     *
     * @param response
     */
    @Override
    public void downLoad(HttpServletResponse response) {

    }

    /**
     * 导入
     *
     * @param file
     */
    @Override
    public void excelImport(MultipartFile file) {
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.getSheetAt(0);
        // 获取所有的行
        int rows = sheet.getPhysicalNumberOfRows();
        // 遍历每行
        for (int rowNumber = 0; rowNumber < rows; rowNumber++) {
            Row row = sheet.getRow(rowNumber);
            // 获取所有列
            int cells = row.getPhysicalNumberOfCells();
            for (int cellNumber = 0; cellNumber < cells; cellNumber++) {
                Cell cell = row.getCell(cellNumber);
                if (Objects.nonNull(cell)) {
                    String cellValue = getCellValueByCellType(cell, wb);
                    System.out.println("第" + rowNumber + "行" + ",第" + cellNumber + "列" + ",值为：" + cellValue);
                }
            }
        }
    }

    /**
     * 根据列的类型获取对应的内容
     *
     * @param cell
     * @return
     */
    private String getCellValueByCellType(Cell cell, Workbook wb) {
        // 获取列的类型
        int cellType = cell.getCellType();
        String cellValue = "";
        HSSFFormulaEvaluator evaluator = new HSSFFormulaEvaluator((HSSFWorkbook) wb);
        switch (cellType) {
            case HSSFCell.CELL_TYPE_STRING: // 字符串
                cellValue = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN: // 布尔
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case HSSFCell.CELL_TYPE_BLANK: // 空
                break;
            case HSSFCell.CELL_TYPE_NUMERIC: //数字
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    // 日期
                    Date value = cell.getDateCellValue();
                    cellValue = DateUtils.dateToString(value, DateUtils.DATE_FORMAT);
                } else {
                    // 不是日期
                    cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                    cellValue = cell.toString();
                }
                break;
            case HSSFCell.CELL_TYPE_FORMULA: // 计算公式
                String formula = cell.getCellFormula();
                CellValue evaluate = evaluator.evaluate(cell);
                cellValue = evaluate.formatAsString();
                break;
            case HSSFCell.CELL_TYPE_ERROR: //类型错误
                System.out.println("类型错误");
                break;
        }
        return cellValue;
    }
}
