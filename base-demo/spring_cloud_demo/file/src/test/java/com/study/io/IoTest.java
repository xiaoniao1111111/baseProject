package com.study.io;

import com.study.pojo.Student;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @类名称:IoTest
 * @类描述:IO流测试
 * @包名:com.study
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-23
 * @版本:V1.0.0
 */
public class IoTest {

    /*================================================字节流======================================================*/

    /**
     * 写一个文字到本地中(暂时不写中文)
     *
     * @throws IOException
     */
    @Test
    public void fileOutputStream() throws IOException {
        // 1.创建对象
        FileOutputStream fileOutputStream = new FileOutputStream("src/test/java/com/study/io/a.txt");
        // 2.写出数据
        fileOutputStream.write(97);
        // 3.关闭资源
        fileOutputStream.close();
    }

    /**
     * 写多个文字到本地中(暂时不写中文)
     *
     * @throws IOException
     */
    @Test
    public void fileOutputStreamMany() throws IOException {
        // 1.创建对象
        FileOutputStream fileOutputStream = new FileOutputStream("src/test/java/com/study/io/b.txt");
        // 2.写出数据
        byte[] bytes = {97, 96, 95, 94, 93};
        fileOutputStream.write(bytes, 1, 3);
        // 3.关闭资源
        fileOutputStream.close();
    }

    /**
     * 换行续写
     */
    @Test
    public void lineFeed() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("src/test/java/com/study/io/e.txt", true);
        String str = "helloWord";
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        fileOutputStream.write(bytes);
        fileOutputStream.write("\r\n".getBytes(StandardCharsets.UTF_8));
        fileOutputStream.write("666".getBytes(StandardCharsets.UTF_8));
        fileOutputStream.close();
    }

    /**
     * 读取文件
     */
    @Test
    public void fileInputStream() throws IOException {
        // 1.创建文件
        FileInputStream fileInputStream = new FileInputStream("src/test/java/com/study/io/e.txt");
        // 2.循环读取
        int b; // 定义一个获取到的变量b
        while ((b = fileInputStream.read()) != -1) { // 将我们读到的数据赋值给b,同时判断返回的内容是否是-1,是: 则不再进行读取,否: 继续读取
            System.out.print((char) b);
        }
        // 3.释放资源
        fileInputStream.close();
    }

    /**
     * 文件拷贝
     *
     * @throws IOException
     */
    @Test
    public void fileCopy() throws IOException {
        // 1.创建对象
        FileInputStream fileInputStream = new FileInputStream("D:\\img\\aa.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\img\\dd.txt");
        try (fileInputStream; fileOutputStream) {
            // 2.文件拷贝(核心思想:边读边写)
            int len;
            byte[] bytes = new byte[1024 * 1024 * 5];
            while ((len = fileInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 编码/解码
     */
    @Test
    public void unicode() throws UnsupportedEncodingException {
        String str = "ai你哟";
        byte[] bytes = str.getBytes();
        System.out.println("UTF-8编码:" + Arrays.toString(bytes));
        System.out.println("---------------------------");
        byte[] gbks = str.getBytes("GBK");
        System.out.println("GBK编码:" + Arrays.toString(gbks));
        System.out.println("----------------------------");
        String s = new String(bytes);
        System.out.println("UTF-8解码:" + s);
        System.out.println("----------------------------");
        String s1 = new String(gbks);
        System.out.println("GBK解码:" + s1);
    }


    /*================================================字符流======================================================*/

    /**
     * 字符流读取文件
     */
    @Test
    public void fileReader() throws IOException {
        // 1.创建文件对象
        FileReader fileReader = new FileReader("src/test/java/com/study/io/b.txt");

        // 2.读取文件
        int ch;
        char[] chars = new char[2];
        while ((ch = fileReader.read(chars)) != -1) {
            System.out.print(chars);
        }

        // 3.释放资源
        fileReader.close();
    }

    /**
     * 字符流: 文件拷贝
     */
    @Test
    public void fileWriteCopy() throws IOException {
        FileReader fileReader = new FileReader("src/test/java/com/study/io/e.txt");
        FileWriter fileWriter = new FileWriter("src/test/java/com/study/io/f.txt", true);
        try (fileWriter; fileReader) {
            int ch;
            char[] chars = new char[1024];
            while ((ch = fileReader.read(chars)) != -1) {
                fileWriter.write(chars, 0, ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件拷贝
     */
    @Test
    public void copyTest() throws IOException {
        // 1.创建原文件对象 目标文件对象
        File resource = new File("D:\\img\\aa");
        File copy = new File("D:\\img\\copy");
        copyDir(resource, copy);
    }

    /**
     * 文件copy逻辑
     *
     * @param resource 目标对象
     * @param copy     拷贝位置
     */
    public void copyDir(File resource, File copy) throws IOException {
        // 1.创建文件夹(如果文件件不存在则创建一个出来,如果存在则不进行任何操作)
        copy.mkdirs();

        // 2.遍历原文件
        for (File file : Objects.requireNonNull(resource.listFiles())) {
            // 2.1如果是文件,则对文件进行拷贝
            if (file.isFile()) {
                BufferedInputStream fileInputStream = new BufferedInputStream(new FileInputStream(file));
                BufferedOutputStream fileOutputStream = new BufferedOutputStream(new FileOutputStream(new File(copy, file.getName())));
                byte[] bytes = new byte[1024];
                int len = 0;
                while ((len = fileInputStream.read(bytes)) != -1) {
                    fileOutputStream.write(bytes, 0, len);
                }
                fileOutputStream.close();
                fileInputStream.close();
            } else {
                // 2.2如果是文件夹,则对该文件夹里面的文件进行拷贝(采用递归的方式)
                copyDir(file, new File(copy, file.getName()));
            }
        }
    }


    /**
     * 文件加密
     */
    @Test
    public void fileEncryption() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/test/java/com/study/io/11.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("src/test/java/com/study/io/12.jpg");
        try (fileOutputStream; fileInputStream) {
            int ch;
            while ((ch = fileInputStream.read()) != -1) {
                fileOutputStream.write(ch ^ 2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 文件解密
     */
    @Test
    public void fileDecode() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/test/java/com/study/io/12.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("src/test/java/com/study/io/13.jpg");
        try (fileOutputStream; fileInputStream) {
            int ch;
            while ((ch = fileInputStream.read()) != -1) {
                fileOutputStream.write(ch ^ 2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过缓存流进行文件拷贝
     *
     * @throws IOException
     */
    @Test
    public void bufferTest() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("src/test/java/com/study/io/buffer.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src/test/java/com/study/io/copyBuffer.txt"));
        int len;
        byte[] bytes = new byte[1024];
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }
        bos.close();
        bis.close();
    }

    /**
     * 字符缓冲流测试
     *
     * @throws IOException
     */
    @Test
    public void bufferReadTest() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/test/java/com/study/io/buffer.txt"));
        String str;
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }
    }

    /**
     * 将对象写入到文件中
     *
     * @throws IOException
     */
    @Test
    public void objectOutputStream() throws IOException {
        // 1.创建对象
        Student student = new Student("张三", "12", "", 0);
        // 2.创建序列化输出流
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/test/java/com/study/io/studenWrite.txt"));
        // 3.写入数据
        objectOutputStream.writeObject(student);
        // 4.关闭流
        objectOutputStream.close();
    }

    /**
     * 从文件中读取对象
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Test
    public void objectInputStream() throws IOException, ClassNotFoundException {
        // 1.创建序列化输入流
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/test/java/com/study/io/studenWrite.txt"));
        // 2.读取数据
        Student stu = (Student) objectInputStream.readObject();
        // 3.关闭流
        objectInputStream.close();
        System.out.println(stu.toString());
    }

    /**
     * 序列化多个对象
     */
    @Test
    public void objectOutputStream2() throws IOException {
        // 1.创建多个对象
        Student student = new Student("张三", "12", "男", 1);
        Student student1 = new Student("李四", "13", "女", 2);
        Student student2 = new Student("王五", "14", "男", 3);
        List<Student> list = Arrays.asList(student, student1, student2);

        // 2.序列化到本地当中
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/test/java/com/study/io/ee.txt"));
        objectOutputStream.writeObject(list);

        // 3.关闭流
        objectOutputStream.close();

    }

    /**
     * 反序列化多个对象
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Test
    public void objectInputStream2() throws IOException, ClassNotFoundException {
        // 1.创建反序列化流对象
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/test/java/com/study/io/ee.txt"));

        // 2.读取数据
        List<Student> studentList = (List<Student>) objectInputStream.readObject();

        // 3.打印数据
        studentList.forEach(System.out::println);

        // 4.关闭流
        objectInputStream.close();
    }

    /**
     * 解压测试
     * 描述: 解压的本质: 把压缩包每一个文件夹,文件读取出来,按照层级拷贝到目的地当中
     */
    @Test
    public void decompression() throws IOException {
        File src = new File("D:\\img\\copy.zip");
        File dest = new File("D:\\img\\zip");

        // 1.创建一个压缩流用来读取压缩包中的数据
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(src));
        // 2.从压缩包里获取每一个zipEntry对象
        ZipEntry zipEntry;
        while ((zipEntry = zipInputStream.getNextEntry()) != null) {
            // 3.判断当前是文件还是文件夹
            if (zipEntry.isDirectory()) {
                // 文件夹: 需要在目的地dest处创建同一个文件夹
                File file = new File(dest, zipEntry.toString());
                file.mkdirs();
            } else {
                // 文件: 读取数据并写入
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(dest, zipEntry.toString())));
                byte[] bytes = new byte[1024];
                int len;
                while ((len = zipInputStream.read(bytes)) != -1) {
                    bufferedOutputStream.write(bytes, 0, len);
                }
                bufferedOutputStream.close();
                // 表示压缩包中的一个文件处理完毕了
                zipInputStream.closeEntry();
            }
        }
        zipInputStream.close();
    }

    /**
     * 压缩
     * 思路:
     * 将我们的文件放入zipEntry中进行压缩
     */
    @Test
    public void compress() throws IOException {
        // 1.创建目标对象
        File src = new File("D:\\img\\aa");
        // 2.创建压缩位置
        File dest = new File("D:\\img\\aa.zip");
        // 3.创建压缩包流关联压缩包
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(dest));
        // 4.遍历文件,将文件放入到zipEntry对象中进行压缩
        toZip(src, zos, src.getName());
        // 5.释放资源
        zos.close();

    }

    /**
     * 压缩
     *
     * @param src        目标数据
     * @param zos        压缩流
     * @param parentName 父级路径
     */
    private void toZip(File src, ZipOutputStream zos, String parentName) throws IOException {
        File[] files = src.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                // 文件: ,并放入压缩流中
                // 1.将文件转换成zipEntry
                ZipEntry zipEntry = new ZipEntry(parentName + "\\" + file.getName());
                // 2.放入到压缩包中
                zos.putNextEntry(zipEntry);
                // 3.读取文件中的数据,写入到压缩包中
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                byte[] bytes = new byte[1024];
                int len;
                while ((len = bufferedInputStream.read(bytes)) != -1) {
                    zos.write(bytes, 0, len);
                }
                // 4.释放资源
                bufferedInputStream.close();
                zos.closeEntry();
            } else {
                // 文件夹: 继续递归文件夹处理该文件夹下的所有文件
                toZip(file, zos, parentName + "\\" + file.getName());
            }
        }

    }

}

