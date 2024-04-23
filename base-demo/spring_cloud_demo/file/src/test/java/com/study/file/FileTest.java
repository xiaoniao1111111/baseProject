package com.study.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

/**
 * @类名称:FileTest
 * @类描述:
 * @包名:com.study
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-21
 * @版本:V1.0.0
 */
public class FileTest {

    /**
     * 根据文件路径创建文件对象
     */
    @Test
    public void createFileOne() {
        File file = new File("D:\\img\\aa.txt");
        System.out.println(file.isFile());
    }

    /**
     * 根据文件的父路径和文件的子路径创建文件对象
     */
    @Test
    public void createFileTwo() {
        String path = "D:\\img";
        String child = "aa.txt";
        File file = new File(path, child);
        System.out.println(file.isFile());
    }

    /**
     * 根据父文件对象和子路径创建文件对象
     */
    @Test
    public void createFileThree() {
        String path = "D:\\img";
        File pathFile = new File(path);
        String child = "aa.txt";
        File file = new File(pathFile, child);
        System.out.println(file.isFile());
    }

    /**
     * 判断此路径是否为文件夹
     */
    @Test
    public void method1() {
        File file = new File("D:\\img\\aa.txt");
        boolean directory = file.isDirectory();
        System.out.println("判断此路径是否为文件夹: " + directory);
    }

    /**
     * 判断此路径是否为文件
     */
    @Test
    public void method() {
        File file = new File("D:\\img\\aa.txt");
        boolean directory = file.isFile();
        System.out.println("判断此路径是否为文件: " + directory);
    }

    /**
     * 判断该文件是否存在
     */
    @Test
    public void method3() {
        File file = new File("D:\\img\\aa.txt");
        boolean directory = file.exists();
        System.out.println("判断该文件是否存在: " + directory);
    }

    /**
     * 返回文件大小(字节数量)
     */
    @Test
    public void method4() {
        File file = new File("D:\\img\\aa.txt");
        long length = file.length();
        System.out.println("返回文件大小(字节数量): " + length);
    }

    /**
     * 返回文件的绝对路径
     */
    @Test
    public void method5() {
        File file = new File("D:\\img\\aa.txt");
        String absPath = file.getAbsolutePath();
        System.out.println("返回文件的绝对路径: " + absPath);
    }

    /**
     * 返回定义文件时的路径
     */
    @Test
    public void method6() {
        File file = new File("D:\\img\\aa.txt");
        String path = file.getPath();
        System.out.println("返回定义文件时的路径: " + path);
    }


    /**
     * 获取文件名
     */
    @Test
    public void method7() {
        File file = new File("D:\\img\\aa.txt");
        String fileName = file.getName();
        System.out.println("获取文件名: " + fileName);
    }

    /**
     * 返回文件的最后修改时间(毫秒值)
     */
    @Test
    public void method8() {
        File file = new File("D:\\img\\aa.txt");
        long modified = file.lastModified();
        System.out.println("返回文件的最后修改时间(毫秒值): " + modified);
    }

    /**
     * 创建一个空的文件
     */
    @Test
    public void method9() throws IOException {
        File file = new File("D:\\img\\bb.txt");
        boolean newFile = file.createNewFile();
        System.out.println("创建一个空的文件: " + newFile);
    }

    /**
     * 文件存在演示
     */
    @Test
    public void method10() throws IOException {
        File file = new File("D:\\img\\bb.txt");
        boolean newFile = file.createNewFile();
        System.out.println("文件存在演示: " + newFile);
    }

    /**
     * 如果父级路径不存在,则创建失败,抛出IOException
     */
    @Test
    public void method11() throws IOException {
        File file = new File("D:\\img\\aa\\bb.txt");
        boolean newFile = file.createNewFile();
        System.out.println("如果父级路径不存在,则创建失败,抛出IOException: " + newFile);
    }

    /**
     * 如果创建的文件没有后缀演示
     */
    @Test
    public void method12() throws IOException {
        File file = new File("D:\\img\\cc");
        boolean newFile = file.createNewFile();
        System.out.println("如果创建的文件没有后缀演示: " + newFile);
    }

    /**
     * 创建单级文件夹:存在 true  不存在  false
     */
    @Test
    public void method13() {
        File file = new File("D:\\img\\aa");
        boolean mkdir = file.mkdir();
        System.out.println("创建单级文件夹: " + mkdir);
    }

    /**
     * 创建多级级文件夹:存在 true  不存在  false
     */
    @Test
    public void method14() {
        File file = new File("D:\\img\\aa\\bb\\cc");
        boolean mkdirs = file.mkdirs();
        System.out.println("创建多级级文件夹: " + mkdirs);
    }


    /**
     * 创建多级级文件夹:存在 true  不存在  false
     */
    @Test
    public void method15() {
        File file = new File("D:\\img\\aa\\bb\\cc");
        boolean mkdirs = file.mkdirs();
        System.out.println("创建多级级文件夹: " + mkdirs);
    }

    /**
     * 删除文件或空文件夹
     */
    @Test
    public void method16() throws IOException {
        File file = new File("D:\\img\\aa\\bb\\cc");
        boolean flag = file.isDirectory();
        if (flag) {
            // 删除空文件夹
            boolean delete = file.delete();
            System.out.println("删除空文件夹: " + delete);
        }
    }

    /**
     * 获取当前路径下的所有内容
     */
    @Test
    public void method17()  {
        File file = new File("D:\\img");
        File[] files = file.listFiles();
        assert files != null;
        Stream.of(files).forEach(item-> System.out.println(item.getName()));
    }

}
