package com.noah.resp;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

/**
 * @Author: WangXinWei
 * @Date: 2019/7/10 15:01
 * @Version 1.0
 */
@ExcelTarget("CompanyInsertResp")
public class CompanyInsertResp {
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
    @Excel(name = "图片链接",type = 2,width =25,height = 30,needMerge = true,savePath = "D:\\image\\companyImage")
    private String image;

    public CompanyInsertResp() {
    }

    public CompanyInsertResp(String companyName, String address, String image) {
        this.companyName = companyName;
        this.address = address;
        this.image = image;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
