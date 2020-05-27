package demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.framework.ReflectiveMethodInvocation;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: filter-aspect-interception
 * @Package: demo.aspect
 * @Description: note
 * @Author: xiangdc16781
 * @CreateDate: 2020-05-27 9:16
 * @UpdateUser: xiangdc16781
 * @UpdateDate: 2020-05-27 9:16
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2020 Hundsun Technologies Inc. All Rights Reserved
 **/
@Aspect
@Component
public class TimeAspect {
    //通过execution()定义切点，参考https://blog.csdn.net/yangshangwei/article/details/77627825
    //execution(<修饰符模式>?<返回类型模式><方法名模式>(<参数模式>)<异常模式>?)
    //其中：返回类型模式、方法名模式、参数模式是必选项。
    //Around 环绕通知: 可修改代理对象的返回值，在此处处理controller下面的所有方法
    @Around("execution(* demo.controller.*.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("time aspect start");
        long start = new Date().getTime();

        // 获取methodInvoke
        Field proxy = pjp.getClass().getDeclaredField("methodInvocation");
        proxy.setAccessible(true);
        ReflectiveMethodInvocation methodInvoke = (ReflectiveMethodInvocation) proxy.get(pjp);


        // 获取增强的类
        String controller = methodInvoke.getMethod().getDeclaringClass().getName();
        // 获取增强的方法名
        String method = methodInvoke.getMethod().getName();
        // 获取增强方法的参数
        Object[] args = methodInvoke.getArguments();

        System.out.println("增强   的    类:"+ controller);
        System.out.println("增强   的  方法:"+ method);
        for (Object arg : args) {
            System.out.println("增强的方法的参数:"+ arg);
        }
        Object object = pjp.proceed();

        System.out.println("time aspect 耗时:"+ (new Date().getTime() - start));

        System.out.println("time aspect end");

        return object;
    }
}
