package com.noah.BufferedReader;

import com.noah.exception.BizException;
import com.noah.util.FileUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * 带有缓冲的读取方式
 *
 * @Author: WangXinWei
 * @Date: 2019/12/23 18:15
 * @Version 1.0
 */
public class BufferedReaderTest {
    public static void main(String[] args) {
        try {
            StringBuilder sb = new StringBuilder();
            // 第一步: 创建FileReader对象
            FileReader fileReader = new FileReader("D:\\excel\\test.txt");
            // 第二步: 缓冲机制,读取文件方式
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            try {
                // 一行一行的读取数据
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }
            } catch (IOException e) {
                throw new BizException("读取异常", e);
            }
            System.out.println("sb = " + sb);

        } catch (FileNotFoundException e) {
            throw new RuntimeException("获取请求内容失败", e);
        }

        System.out.println(" = >>>>>>>>>>>>>");
        List<String> fileContentList = FileUtils.getFileContentList("D:\\excel\\test.txt");
        fileContentList.forEach(System.out::print);

    }

}
