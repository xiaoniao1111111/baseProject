package com.noah.resp;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.util.Objects;

/**
 * @Author: WangXinWei
 * @Date: 2019/7/5 14:51
 * @Version 1.0
 */
@ExcelTarget("CompanyResp")
public class CompanyResp {

    /**
     * 公司名
     */
    @Excel(name="公司名",isImportField = "true_st",needMerge=true,width = 25)
    private String companyName;

    /**
     * 公司地址
     */
    @Excel(name = "公司地址",isImportField = "true_st",needMerge=true,width = 25)
    private String address;

    /**
     * 图片链接
     */
    @Excel(name = "图片链接",type = 2,width =25,height = 30,needMerge = true)
    private String image;


    public CompanyResp() {
    }

    public CompanyResp(String companyName, String image, String address) {
        this.companyName = companyName;
        this.image = image;
        this.address = address;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
