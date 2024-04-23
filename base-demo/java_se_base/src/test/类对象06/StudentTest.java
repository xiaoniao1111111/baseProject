package test.类对象06;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: WangXinWei
 * @Date: 2023/05/04/15:46
 * @Description:
 */
public class StudentTest {
    public static void main(String[] args) {
        Student student1 = new Student("王1", "男", 11, "语文", 85);
        Student student2 = new Student("王2", "男", 12, "语文", 85);
        Student student3 = new Student("王1", "女", 13, "英语", 85);
        Student student4 = new Student("王2", "女", 11, "英语", 90);
        Student student5 = new Student("王5", "女", 11, "英语", 91);
        Student student6 = new Student("王6", "女", 11, "英语", 92);
        Student student7 = new Student("王7", "女", 11, "数学", 85);
        Student student8 = new Student("王8", "女", 11, "数学", 90);
        Student student9 = new Student("王9", "女", 11, "历史", 85);
        Student student10 = new Student("王10", "女", 11, "历史", 90);
        Student student11 = new Student("王3", "女", 12, "语文", 92);
        Student student12 = new Student("王5", "女", 11, "语文", 93);
        List<Student> stuList = new ArrayList<>();
        stuList.add(student1);
        stuList.add(student2);
        stuList.add(student3);
        stuList.add(student4);
        stuList.add(student5);
        stuList.add(student6);
        stuList.add(student7);
        stuList.add(student8);
        stuList.add(student9);
        stuList.add(student10);
        stuList.add(student11);
        stuList.add(student12);
        // 返回每个科目分数都在90以上的所有女同学的数组，并根据语文分数和同学姓名排序
        List<Student> filterStus = stuList.stream().filter(item -> Objects.equals(item.getSex(), "女")
                        && item.getSore() > 90 && Objects.equals(item.getSubject(), "语文"))
                .sorted(Comparator.comparing(Student::getName).thenComparing(Student::getSore)).collect(Collectors.toList());
        filterStus.forEach(item -> {
            System.out.println("科目: " + item.getSubject() + ",姓名: " + item.getName() + ",分数: " + item.getSore());
        });
        System.out.println("-----------------------------");
        // 返回英语分数前50的同学姓名
        List<Student> englishStus = stuList.stream().filter(item -> Objects.equals(item.getSubject(), "英语"))
                .sorted(Comparator.comparing(Student::getSore).reversed()).collect(Collectors.toList());
        List<Student> newEnglishStus = new ArrayList<>();
        int max = 50;
        for (int i = 0; i < englishStus.size(); i++) {
            if (i <= 50) {
                newEnglishStus.add(englishStus.get(i));
            }
        }
        newEnglishStus.forEach(item -> {
            System.out.println("科目:" + item.getSubject() + ",姓名: " + item.getName() + ",分数: " + item.getSore());
        });
        System.out.println("-----------------------------");
        // 返回每个科目的第一名的科目-同学姓名-分数
        Map<String, List<Student>> collect = stuList.stream().collect(Collectors.groupingBy(Student::getSubject));
        List<Student> firstStus = new ArrayList<>();
        collect.forEach((subject, stus) -> {
            Student student = stus.stream().max(Comparator.comparing(Student::getSore)).get();
            firstStus.add(student);
        });
        firstStus.forEach(item -> {
            System.out.println("科目为: " + item.getSubject() + ",姓名为: " + item.getName() + ",分数为: " + item.getSore());
        });
    }
}
