package com.spring.srping.iocannotation;

import com.spring.srping.instanceBean.Bean4;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author WangXinWei
 * @Date 2022/3/5 18:06
 * @Version 1.0
 */
@Data
@Component("annotationTest")
public class AnnotationBean {
    // 属性注入通过注解注入的四种方式
/*        @Value("张三")
        private String name;*/

    // 方式二:
/*        @Autowired
        private Bean4 bean4;*/

    // 方式三:
        @Resource
        private Bean4 bean4;

    // 方式四
    /*
        @Inject
        private Bean4 bean4;
    */


    public void save() {
        System.out.println("数据保存....");
    }

    public Bean4 getBean4() {
        return bean4;
    }

    public void setBean4(Bean4 bean4) {
        this.bean4 = bean4;
    }
}
