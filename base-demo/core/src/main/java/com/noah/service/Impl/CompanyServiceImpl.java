package com.noah.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.noah.domain.Company;
import com.noah.mapper.CompanyMapper;
import com.noah.service.ICompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Author: WangXinWei
 * @Date: 2019/7/5 14:41
 * @Version 1.0
 */
@Service
@Slf4j
public class CompanyServiceImpl implements ICompanyService {
    @Autowired
    private CompanyMapper companyMapper;

    /**
     * 获取公司信息
     */
    @Override
    public List<Company> listCompany() {
        QueryWrapper<Company> queryWrapper = new QueryWrapper<>();
        return companyMapper.selectList(queryWrapper);
    }

    /**
     * 根据userId获取Company
     * @param id
     * @return
     */
    @Override
    public Company getCompanyByUserId(Long  id) {
        QueryWrapper<Company> companyQueryWrapper = new QueryWrapper<>();
        companyQueryWrapper.eq("user_id",id);
        List<Company> companies = companyMapper.selectList(companyQueryWrapper);
        return CollectionUtils.isEmpty(companies)?null:companies.get(0);
    }
}
