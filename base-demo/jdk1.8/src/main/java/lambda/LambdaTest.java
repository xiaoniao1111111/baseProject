package lambda;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * JDK1.8(Java8)--lambda
 *
 * @Author: WangXinWei
 * @Date: 2019/12/12 9:38
 * @Version 1.0
 */
public class LambdaTest {
    @Test
    public void testByLambda() {
        Fuit apple = new Fuit();
        apple.setFuitName("苹果");
        apple.setFuitPrice("1");
        Fuit banana = new Fuit();
        banana.setFuitName("香蕉");
        banana.setFuitPrice("2");
        Fuit prea = new Fuit();
        prea.setFuitName("梨");
        prea.setFuitPrice("3");
        Fuit orange = new Fuit();
        orange.setFuitName("橘子");
        orange.setFuitPrice("4");
        // List<Fuit> fuitList = Arrays.asList(apple, banana, prea, orange);
        List<Fuit> fuits = new ArrayList<>();
        fuits.add(apple);
        fuits.add(banana);
        fuits.add(prea);
        fuits.add(orange);
        Map<String, List<Fuit>> fuitNameAndFuitMap = fuits.stream().collect(Collectors.groupingBy(Fuit::getFuitName));
        // 多个参数需要加小括号
        /*fuitNameAndFuitMap.forEach((fuitName, fuitList) -> {
            System.out.println("水果名称: " + fuitName + " 水果价格: " + fuitList.get(0).getPrice());
        });*/

        /*// 主体一个语句不需要大括号
        fuitNameAndFuitMap.forEach((fuitName, fuitList) ->
                System.out.println("水果名称: " + fuitName + " 水果价格: " + fuitList.get(0).getPrice()));*/

        /*// 主体多个语句需要大括号
        fuitNameAndFuitMap.forEach((fuitName, fuitList) ->{
            System.out.println("水果名称: " + fuitName );
            System.out.println("水果价格 = " + fuitList.get(0).getPrice());});*/

        // 直接返回返回值内容,不需要定义类型
        //listFuit(fuits).forEach(System.out::println);

        /*// 方法引用--按照水果价格升序排序
        fuits.stream().sorted(Comparator.comparing(Fuit::getFuitPrice)).collect(Collectors.toList())
                .forEach(fuit -> System.out.println("水果名称: " + fuit.getFuitName() + " 水果价格: " + fuit.getFuitPrice()));*/
      /*  ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        List<Integer> integers1 = Arrays.asList(5, 6, 7, 8, 9);
        integers.retainAll(integers1);
        System.out.println("获取公共的元素 " + integers);*/
    }
    /*public List<String> listFuit(List<Fuit> fuits){
        return fuits.stream().map(Fuit::getFuitName).collect(Collectors.toList());
    }*/


}
