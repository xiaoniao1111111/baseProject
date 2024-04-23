package com.spring.springmvc.fileUpload.exception;

import com.noah.exception.BizException;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 文件上传异常处理类
 *
 * @Author WangXinWei
 * @Date 2022/3/13 13:31
 * @Version 1.0
 */
@Component
public class FileUploadException implements HandlerExceptionResolver {

    @SneakyThrows
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        if (e instanceof MaxUploadSizeExceededException) {
            httpServletResponse.setHeader("content-type", "text/html;charset=utf-8");
            throw new BizException("上传单个文件大小不得超过5M");
        }
        return new ModelAndView();
    }
}
