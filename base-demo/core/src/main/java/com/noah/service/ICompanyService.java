package com.noah.service;

import com.noah.domain.Company;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author: WangXinWei
 * @Date: 2019/7/5 14:41
 * @Version 1.0
 */
public interface ICompanyService {

    /**
     * 获取公司信息
     */
    List<Company> listCompany();

    /**
     * 根据userId获取Company
     * @param id
     * @return
     */
    Company getCompanyByUserId(Long id);
}
