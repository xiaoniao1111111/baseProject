package com.spring.springmvc.fileUpload;

import com.noah.exception.BizException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Objects;

/**
 * 文件上传
 *
 * @Author WangXinWei
 * @Date 2022/3/13 12:31
 * @Version 1.0
 */
@RestController
@RequestMapping("/file")
public class FileUploadController {
    /**
     * 上传单个文件
     * @param response
     * @param file
     */
    @PostMapping("/upload")
    public void fileUpload(HttpServletResponse response,@RequestParam("file") MultipartFile file) {
        try {
            if (Objects.isNull(file)) {
                return;
            }
            // 将上传的文件保存在指定位置
            file.transferTo(new File("D:\\image\\" + file.getOriginalFilename()));
            response.setHeader("content-type", "text/html;charset=utf-8");
            response.getWriter().print("文件上传成功");
        } catch (Exception e) {
            throw new BizException("文件上传异常");
        }
    }

    /**
     * 上传多个文件
     * @param response
     * @param file
     */
    @PostMapping("/upload/list")
    public void fileUploadList(HttpServletResponse response,@RequestParam("files") MultipartFile[] files) {
        try {
            if (Objects.isNull(files)) {
                return;
            }
            for (MultipartFile file : files) {
                // 将上传的文件保存在指定位置  file.getOriginalFilename(): 获取文件名称
                file.transferTo(new File("D:\\image\\" + file.getOriginalFilename()));
                response.setHeader("content-type", "text/html;charset=utf-8");
                response.getWriter().print("文件上传成功");
            }
        } catch (Exception e) {
            throw new BizException("文件上传异常");
        }
    }
}
