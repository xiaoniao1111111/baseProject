package com.srping.instanceBean;

import com.spring.srping.instanceBean.Bean1;
import com.spring.srping.instanceBean.Bean2;
import com.spring.srping.instanceBean.Bean3;
import com.spring.srping.instanceBean.Bean4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author WangXinWei
 * @Date 2022/3/2 9:07
 * @Version 1.0
 */
public class IntanceBeanTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Bean1 bean1 = (Bean1) ac.getBean("bean1");
        System.out.println("bean1 = " + bean1);
        Bean2 bean2 = (Bean2) ac.getBean("bean2");
        System.out.println("bean2 = " + bean2);
        Bean3 bean3 = (Bean3) ac.getBean("bean3");
        System.out.println("bean3 = " + bean3);
        Bean4 bean14 = (Bean4) ac.getBean("bean4");
        System.out.println("bean14 = " + bean14);
    }
}
