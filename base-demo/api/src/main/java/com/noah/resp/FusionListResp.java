package com.noah.resp;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.noah.domain.Company;
import com.noah.domain.TbItem;
import org.hibernate.validator.constraints.EAN;

import java.util.List;

/**
 * @Author: WangXinWei
 * @Date: 2019/7/10 10:05
 * @Version 1.0
 */
@ExcelTarget("FusionListResp")
public class FusionListResp {
    /**
     * 姓名
     */
    @Excel(name="姓名",isImportField="true_st",needMerge=true,width = 25)
    private String name;

    /**
     * 年龄
     */
    @Excel(name="年龄",isImportField = "true_st",needMerge=true,width = 25)
    private Integer age;

    /**
     * 性别，1男性，2女性
     */
    @Excel(name = "性别",replace = {"男_true","女_false"},needMerge=true,width = 25)
    private Boolean sex;

    /**
     * 对应公司
     * */
    @ExcelEntity(name="公司")
    private CompanyResp companyResp;

    /**
     * 对应主题
     * */
    @ExcelCollection(name="主题",orderNum = "4")
    private List<ItemResp> itemResps;

    public FusionListResp() {
    }

    public FusionListResp(String name, Integer age, Boolean sex, CompanyResp companyResp, List<ItemResp> itemResps) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.companyResp = companyResp;
        this.itemResps = itemResps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public CompanyResp getCompanyResp() {
        return companyResp;
    }

    public void setCompanyResp(CompanyResp companyResp) {
        this.companyResp = companyResp;
    }

    public List<ItemResp> getItemResps() {
        return itemResps;
    }

    public void setItemResps(List<ItemResp> itemResps) {
        this.itemResps = itemResps;
    }
}
