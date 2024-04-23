/*
package com.srping;

import com.alibaba.fastjson.JSONObject;
import com.spring.srping.service.IUserService;
import com.spring.srping.iocannotation.AnnotationBean;
import com.spring.srping.instanceBean.Bean4;
import com.spring.srping.instanceBeanBak.Bean2Bak;
import com.spring.srping.instanceBeanBak.Bean3Bak;
import com.spring.srping.instanceBeanBak.Bean4Bak;
import com.spring.srping.lifeCycle.LifeCycleBean;
import com.spring.srping.properity.ConstructorBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

*/
/**
 * @Author WangXinWei
 * @Date 2022/3/2 8:23
 * @Version 1.0
 *//*

public class UserDaoBakTest {
    public static void main(String[] args) {
      // 1. 通过工厂获取benan
      // getBean();

        // 2. DI依赖注入
       // getDITest();

        // 3. 实例化Bean的四种方式
        //fourBeanTest();

        // 4. bean的作用域
        //scopeTest();

        // 5. bean的生命周期
       // lifeCycleTest();

        // 6. bean的属性注入方式(构造器和set)
      //  constructorTest();

        // 7. 实例化bean: 使用注解方式
       //annotationTest();

        // 8. 属性依赖注入: 使用注解的方式
       // ProperityAnn();

        // 9. 生命周期: 初始化和销毁 使用注解
        //lifeCycleAnn();

        // 10. 作用域: 使用注解的方式
       // socopeAnn();

        // 11. 监听器
    }

    private static void socopeAnn() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object bean = ac.getBean("singletonBean");
        System.out.println("bean = " + bean);
        Object bean1 = ac.getBean("singletonBean");
        System.out.println("bean1 = " + bean1);
        Object bean2 = ac.getBean("prototypeBean");
        System.out.println("bean2 = " + bean2);
        Object bean3 = ac.getBean("prototypeBean");
        System.out.println("bean3 = " + bean3);
    }

    private static void lifeCycleAnn() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        LifeCycleBean bean= (LifeCycleBean) ac.getBean("lifeCycleBean");
        ac.close();
    }

    private static void ProperityAnn() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AnnotationBean bean = (AnnotationBean) ac.getBean("annotationTest");
        Bean4 bean4 = bean.getBean4();
        System.out.println(bean4);
    }

    private static void annotationTest() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AnnotationBean annotationTest = (AnnotationBean) ac.getBean("annotationTest");
        annotationTest.save();
    }

    private static void constructorTest() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        ConstructorBean bean = (ConstructorBean) ac.getBean("constructorBean");
        System.out.println(JSONObject.toJSONString(bean));
        ConstructorBean bean1 = (ConstructorBean) ac.getBean("setBean");
        System.out.println(JSONObject.toJSONString(bean1));
    }

    private static void lifeCycleTest() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object lifeCycleBean = ac.getBean("lifeCycleBean");
        ac.close();
        System.out.println(lifeCycleBean);
    }

    private static void scopeTest() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object singletonBean = ac.getBean("singletonBean");
        System.out.println("singletonBean = " + singletonBean);
        Object singletonBean1 = ac.getBean("singletonBean");
        System.out.println("singletonBean1 = " + singletonBean1);
        Object singletonBean2 = ac.getBean("singletonBean");
        System.out.println("singletonBean2 = " + singletonBean2);
        Object singletonBean3 = ac.getBean("singletonBean");
        System.out.println("singletonBean3 = " + singletonBean3);
        Object prototypeBean = ac.getBean("prototypeBean");
        System.out.println("prototypeBean = " + prototypeBean);
        Object prototypeBean1 = ac.getBean("prototypeBean");
        System.out.println("prototypeBean1 = " + prototypeBean1);
        Object prototypeBean2 = ac.getBean("prototypeBean");
        System.out.println("prototypeBean2 = " + prototypeBean2);
        Object prototypeBean3 = ac.getBean("prototypeBean");
        System.out.println("prototypeBean3 = " + prototypeBean3);
    }

    private static void fourBeanTest() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContextBak.xml");
        Bean2Bak bean2 = (Bean2Bak) ac.getBean("bean2Bak");
        System.out.println("bean2 = " + bean2);
        Bean3Bak bean3 = (Bean3Bak) ac.getBean("bean3Bak");
        System.out.println("bean3 = " + bean3);
        Bean4Bak bean4 = (Bean4Bak) ac.getBean("bean4Bak");
        System.out.println("bean4 = " + bean4);
    }

    private static void getDITest() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContextBak.xml");
        IUserService userService = (IUserService) ac.getBean("userServiceImpl");
        userService.login();
    }

    private static void getBean() {
        // 获取spring工厂对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContextBak.xml");
        // 获取对象
        IUserService userService = (IUserService) ac.getBean("userService");
        userService.login();
    }
}
*/
