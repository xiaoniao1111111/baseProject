package test.file;

import java.io.File;
import java.io.IOException;

/**
 * @Author WangXinWei
 * @Date 2022/2/9 22:31
 * @Version 1.0
 */
public class FileTest {

    public static void main(String[] args) {
        // 1. File文件创建对象中构造方法三种方式演练
       // consMethodTest();
        // 2. File获取方法演练
       // getFile();
        // 3. 文件判断
       // equalsFile();
        // 4. 删除和创建文件
        //deleteOrCreateFile();
        // 5. 创建文件夹
        File file = new File("D:\\aa");
        // 创建单级文件夹
        boolean mkdir = file.mkdir();
        System.out.println(mkdir);
        // 创建多级文件夹
        File file1 = new File("D:\\aa\\bb\\cc");
        boolean mkdirs = file1.mkdirs();
        System.out.println(mkdirs);
    }

    private static void deleteOrCreateFile() {
        File file = new File("D:\\获取文件大小测试\\bbb");
        boolean delete = file.delete();
        System.out.println(delete);
        try {
            boolean newFile = file.createNewFile();
            System.out.println(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void equalsFile() {
        File file = new File("D:\\获取文件大小测试\\11.txt");
        // 判断指定路径下是否是文件
        boolean file1 = file.isFile();
        System.out.println(file1);
        // 判断指定的路径是否存在
        boolean exists = file.exists();
        System.out.println(exists);
        // 判断指定的路径是否是隐藏文件
        boolean hidden = file.isHidden();
        System.out.println(hidden);
    }

    private static void getFile() {
        File file = new File("D:\\AAA\\BBB");
        // 获取文件的绝对路径
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);
        // 获取文件的相对路径
        String path = file.getPath();
        System.out.println(path);
        // 获取文件名
        File file1 = new File("D:\\aaa\\bbb.txt");
        String name = file1.getName();
        System.out.println(name);
        // 获取文件大小
        File file2 = new File("D:\\获取文件大小测试\\11.txt");
        long length = file2.length();
        System.out.println(length);
    }

    private static void consMethodTest() {
        // 方式一: 直接传入绝对路径
        File file = new File("D/:AAA");
        System.out.println(file);
        // 方式二: 第一步: 根路径生成一个文件,作为第一个参数传递,第二步: 传入子路径作为第二个参数,最终相关两级路径的文件
        File file1 = new File(file, "/bbb");
        System.out.println(file1);
        // 方式三: 第一个参数是一级路径,第二个参数是二级路径,最终生成全路径的一个文件
        String fuUrl = "D:/aaa";
        String ziUrl = "/bbb";
        File file2 = new File(fuUrl + ziUrl);
        System.out.println(file2);
    }
}
