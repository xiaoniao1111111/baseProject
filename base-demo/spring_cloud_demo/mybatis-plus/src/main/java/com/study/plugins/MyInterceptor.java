/*
package com.study.plugins;


import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.util.Properties;
import java.util.concurrent.Executor;

*/
/**
 * @类名称:MyInterceptor
 * @类描述:
 * @包名:com.study.plugins
 * @项目名称:base-demo
 * @作者:wxw
 * @日期:2024-03-20
 * @版本:V1.0.0
 *//*

@Intercepts({
        @Signature(
                type = Executor.class,
                method = "select", // 拦截的方法是查询方法
                args = {MappedStatement.class, Object.class}
        )
})
public class MyInterceptor implements Interceptor {

    */
/**
     * 执行方法拦截
     *
     * @param invocation
     * @return
     * @throws Throwable
     *//*

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
       // 拦截方法,具体业务逻辑编写的位置
        return invocation.proceed(); // 放行的意思
    }

    */
/**
     * @param target
     * @return
     *//*

    @Override
    public Object plugin(Object target) {
        // 对我们的目标对象进行代理,目的就是将我们的拦截器加入到对象中
        return Plugin.wrap(target, this);
    }

    */
/**
     * @param properties
     *//*

    @Override
    public void setProperties(Properties properties) {
        // 属性设置
    }
}
*/
