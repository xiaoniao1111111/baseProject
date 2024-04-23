package com.spring.srping.aopannotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author WangXinWei
 * @Date 2022/3/10 13:35
 * @Version 1.0
 */
@Component
@Aspect
public class MyAspect {
    /**
     * 前置通知
     */
    // 意思是在这个包下,所有的方法都会做前置增强
    @Before("execution(* com.spring..*.*(..))")
    public void before() {
        System.out.println("前置方法执行....");
    }

    /**
     * 后置通知
     * 参数中多了一个业务逻辑返回值,增强代码的时候使用
     *
     * @param joinPoint 连接点对象(包含: 方法,参数,目标对象)
     * @param returnVal 目标方法执行的返回值
     */
    @AfterReturning(value = "execution(* com.spring..*.*(..))", returning = "returnVal")
    public void afterReturning(JoinPoint joinPoint, Object returnVal) {
        System.out.println("后置方法执行了.....");
    }

    /**
     * 环绕通知
     *
     * @param joinPoint 可以执行的连接点对象,也就是通过这个对象可以随时随地的执行目标方法,从而做前后功能增强
     * @return
     * @throws Throwable
     */
    @Around(value = "execution(* com.spring..*.*(..))")
    public Object aound(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知前...");
        Object proceed = joinPoint.proceed();
        System.out.println("环绕通知后....");
        return proceed;
    }

    /**
     * 抛出通知
     *
     * @param joinPoint 连接点对象
     * @param throwable 异常信息
     */
    @AfterThrowing(value = "execution(* com.spring..*.*(..))", throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {
        System.out.println("抛出通知执行了....");
    }

    @After(value = "execution(* com.spring..*.*(..))")
    public void after(JoinPoint joinPoint){
        System.out.println("最终通知执行了...");
    }
}
