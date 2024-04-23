package com.noah;

import com.github.pagehelper.Page;
import com.noah.common.PaginationFront;
import com.noah.common.PaginationRequest;
import com.noah.domain.TbUser;
import com.noah.req.PageReq;
import com.noah.service.ITbUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.alibaba.fastjson.JSON;

/**
 * @Author: WangXinWei
 * @Date: 2019/5/30 10:18
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class queryTbuserInfoTest {
    @Autowired
    private ITbUserService iTbUserService;
    @Test
    public  void main() {
        PageReq pageReq = new PageReq();
        pageReq.setAge(30);
        PaginationFront paginationFront = new PaginationFront();
        paginationFront.setCurrentPage(1);
        paginationFront.setPageSize(10);
        PaginationRequest<PageReq> pageReqPaginationRequest = new PaginationRequest<>();
        pageReqPaginationRequest.setData(pageReq);
        pageReqPaginationRequest.setPaginationFront(paginationFront);
        Page<TbUser> tbUserByID = iTbUserService.getTbUserByID( pageReqPaginationRequest);
        log.info("分组后的tbUserByID为:"+JSON.toJSONString(tbUserByID));
       System.out.println("测试获取tbUserByID = " + tbUserByID);
    }
}
