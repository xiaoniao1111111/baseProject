package com.noah.service;

import com.noah.common.BaseResponse;
import com.noah.domain.TbUser;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author: WangXinWei
 * @Date: 2019/7/5 9:25
 * @Version 1.0
 */
public interface IExcelService {
    /**
     * user信息excel导出
     * @return
     */
    void userInfoExcelDownload(HttpServletResponse response);

    /**
     * 公司图片导出
     * @param response
     */
    void companyImageExcelDownload(HttpServletResponse response);

    /**
     * user信息Excel导入
     */
    void userInfoExcelInsert();

    /**
     * 融合用户、公司、主题 导出
     * @param response
     */
    void listFusionDownload(HttpServletResponse response);

    /**
     *  图片导入
     * @param response
     */
    void companyImageExcelInsert(HttpServletResponse response);

    /**
     * user信息excel导出 方式二
     * @param response
     */
    void userInfoExcelDownloadWayTwo(HttpServletResponse response);

    /**
     * 用户信息和公司信息 Excel导出
     * @param response
     */
    void usersAndCompanyExcelDownload(HttpServletResponse response);

    /**
     * 用户信息导入
     */
    List<TbUser>userInfoExcelImport();
}
