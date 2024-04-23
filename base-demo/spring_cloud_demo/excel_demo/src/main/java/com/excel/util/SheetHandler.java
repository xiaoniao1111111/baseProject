package com.excel.util;

import com.excel.pojo.User;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.usermodel.XSSFComment;

/**
 * @Author: WangXinWei
 * @Date: 2024-01-16-18:56
 * @Version 1.0
 */
public class SheetHandler implements XSSFSheetXMLHandler.SheetContentsHandler {
    //    编号 用户名  手机号  入职日期 现住址
    private User user = null;

    /**
     * 每一行的开始   rowIndex代表的是每一个sheet的行索引
     *
     * @param rowIndex
     */
    @Override
    public void startRow(int rowIndex) {
        if (rowIndex == 0) {
            user = null;
        } else {
            user = new User();
        }
    }

    /**
     * 处理每一行的所有单元格
     *
     * @param cellName
     * @param cellValue
     * @param comment
     */
    @Override
    public void cell(String cellName, String cellValue, XSSFComment comment) {
        // 组装数据
        if (user != null) {
            String letter = cellName.substring(0, 1);  //每个单元名称的首字母 A  B  C
            switch (letter) {
                case "A": {
                    user.setId(Long.parseLong(cellValue));
                    break;
                }
                case "B": {
                    user.setUserName(cellValue);
                    break;
                }
            }
        }
    }

    /**
     * 每一行的结束处理
     *
     * @param rowIndex
     */
    @Override
    public void endRow(int rowIndex) {
        if (rowIndex != 0) {
            System.out.println(user);
        }

    }
}
