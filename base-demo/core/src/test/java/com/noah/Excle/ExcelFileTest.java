package com.noah.Excle;

import com.noah.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.util.StringUtils;

import java.io.File;

/**
 * @Author: WangXinWei
 * @Date: 2019/12/20 17:18
 * @Version 1.0
 */
@Slf4j
public class ExcelFileTest {
    public static void main(String[] args) {
        String ss="";
        if (StringUtils.isEmpty(ss)) {
            throw new BizException("该字符串不能为空");
        }
        int length = ss.length();
        System.out.println("该字符的长度: " + length);
    }
}
