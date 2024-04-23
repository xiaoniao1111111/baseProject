package Optional;

import org.junit.Test;
import tk.mybatis.mapper.genid.GenId;

import java.util.Optional;

/**
 *
 * @Author: WangXinWei
 * @Date: 2019/12/12 16:43
 * @Version 1.0
 */
public class OptionalTest {
    @Test
    public void testByOptional(){
        // empty
/*        Optional<Object> empty = Optional.empty();
        System.out.println("返回一个空的Optional: " + empty);*/

        // get()与of()
        Optional<String> optional = Optional.of("你好");
        String s = optional.get();
        System.out.println("获取字符串对象: " + s);

        /*Optional<String> optional = Optional.of("你好");
        boolean present = optional.isPresent();
        System.out.println("该容器是否为空: " + present);
        Optional<Object> nullOptional = Optional.of(null);
        boolean present1 = nullOptional.isPresent();
        System.out.println("空的容器测试: " + present1);*/

        /*// orElse  orElseGet
        Optional<String> optional = Optional.of("hello");
        String hello = optional.orElse("其他");
        System.out.println("如果有值返回结果: " + hello);*/

        /*Optional<String> emptyOptional = Optional.of("");
        String aa = emptyOptional.orElse("其他");
        System.out.println("如果该容器为空字符串结果: " + aa);*/

       /* Optional<Object> nullOptional = Optional.of(null);
        Object other = nullOptional.orElse("其他");
        System.out.println("该容器为空结果: " + other);*/

        // ofNullable
/*        Object other = Optional.ofNullable(null).orElse("其他");
        System.out.println("other = " + other);*/
    }
}
