package com.noah.resp;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

/**
 * @Author: WangXinWei
 * @Date: 2019/7/10 9:45
 * @Version 1.0
 */
@ExcelTarget("ItemResp")
public class ItemResp {
    /**
     * 商品名称
     */
    @Excel(name="商品名称",isImportField = "true_st")
    private String itemName;

    /**
     * 商品价格
     */
    @Excel(name = "商品价格",isImportField = "true_st")
    private Float itemPrice;

    /**
     * 商品描述
     */
    @Excel(name="商品描述",isImportField = "true_st")
    private String itemDetail;

    public ItemResp() {
    }

    public ItemResp(String itemName, Float itemPrice, String itemDetail) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemDetail = itemDetail;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Float itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemDetail() {
        return itemDetail;
    }

    public void setItemDetail(String itemDetail) {
        this.itemDetail = itemDetail;
    }
}
