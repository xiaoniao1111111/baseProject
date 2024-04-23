package com.study.io;

import cn.hutool.core.util.StrUtil;
import com.sun.javafx.tools.packager.bundlers.RelativeFileSet;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @类名称:CommonsIoTest
 * @类描述:
 * @包名:com.study.io
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-26
 * @版本:V1.0.0
 */
public class CommonsIoTest {
    /**
     * 将一个文件拷贝到另一个文件中
     *
     * @throws IOException
     */
    @Test
    public void copyFile() throws IOException {
        FileUtils.copyFile(new File("D:\\img\\aa.txt"), new File("D:\\img\\newCopy.txt"));

    }

    /**
     * 将一个文件夹拷贝到另一个文件夹中
     *
     * @throws IOException
     */
    @Test
    public void copyDirectory() throws IOException {
        FileUtils.copyDirectory(new File("D:\\img\\aa"), new File("D:\\img\\newCopy"));
    }

    /**
     * 清空当前文件夹下的所有文件和文件夹
     *
     * @throws IOException
     */
    @Test
    public void cleanDirectory() throws IOException {
        FileUtils.cleanDirectory(new File("D:\\img\\newCopy"));
    }

    /**
     * 删除文件夹(包含里面的文件和文件夹)
     *
     * @throws IOException
     */
    @Test
    public void deleteDirectory() throws IOException {
        FileUtils.deleteDirectory(new File("D:\\img\\newCopy"));
    }

    /**
     * 读取文件中的内容,并转换成字符串
     *
     * @throws IOException
     */
    @Test
    public void readFileToString() throws IOException {
        String s = FileUtils.readFileToString(new File("D:\\img\\dd.txt"), StandardCharsets.UTF_8);
        System.out.println(s);
    }

    /**
     * 写入数据
     *
     * @throws IOException
     */
    @Test
    public void write() throws IOException {
        String s = FileUtils.readFileToString(new File("D:\\img\\aa.txt"), Charset.defaultCharset());
        FileUtils.write(new File("D:\\img\\gg.txt"), s, "UTF-8");
    }

    /**
     * IO流 文件复制
     *
     * @throws IOException
     */
    @Test
    public void ioCopy() throws IOException {
        IOUtils.copy(new FileInputStream("D:\\img\\aa.txt"), new FileOutputStream("D:\\img\\aaa.txt"));
    }

    /**
     * IO流 大文件复制
     *
     * @throws IOException
     */
    @Test
    public void copyLarge() throws IOException {
        IOUtils.copyLarge(new FileReader("D:\\img\\aa.txt"), new FileWriter("D:\\img\\aaaa.txt"));
    }

    /**
     * 读取数据
     *
     * @throws IOException
     */
    @Test
    public void readLines() throws IOException {
        List<String> strings = IOUtils.readLines(new FileReader("D:\\img\\aa.txt"));
        strings.forEach(System.out::println);
    }

    /**
     * 写入数据
     *
     * @throws IOException
     */
    @Test
    public void ioWrite() throws IOException {
        List<String> strings = IOUtils.readLines(new FileReader("D:\\img\\aa.txt"));
        IOUtils.write(strings.toString(), new FileOutputStream("D:\\img\\ioaa.txt"));
    }

    /**
     * 从网络中爬取数据
     */
    @Test
    public void webCrawlerTest() throws IOException {
        // 1.爬取路径
        String src = "https://wenku.baidu.com/view/a98f113a10661ed9ad51f3ab.html?fr=aladdin664466&ind=1&aigcsid=39662&qtype=0&lcid=1&queryKey=%E5%90%8D%E5%AD%97&_wkts_=1711453505546&bdQuery=%E5%90%8D%E5%AD%97";
        // 2. 创建一个url对象
        URL url = new URL(src);
        // 3.建立连接
        URLConnection urlConnection = url.openConnection();
        // 4.读取数据流
        InputStreamReader inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
        // 4. 遍历,组装结果集
        StringBuilder sb = new StringBuilder();
        char[] bytes = new char[1024];
        int len;
        while ((len= inputStreamReader.read(bytes))!=-1){
            System.out.println(new String(bytes));
            sb.append(new String(bytes));
        }
        // 5.此时返回的数据包含:html各种数据,并不是我们想要的,此时我们可以采用正则的方式,获取我们想要的数据
        List<String> list = new ArrayList<>();
        String regex = "(、{2})(、)";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(sb);
        while (matcher.find()){
            System.out.println(matcher.group());
            list.add(matcher.group(1));
        }

    }
}
