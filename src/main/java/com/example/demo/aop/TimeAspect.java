package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**  
* @Title: TimeAspect.java  
* @Package com.example.demo.aop  
* @Description: TODO
* @author wdm  
* @date 2018年4月3日  上午10:07:06
* @version V1.0  
*/
@Aspect
@Component
public class TimeAspect {
	@Around("execution(* com.example.demo.controller.FastJsonController..*(..))")
    public Object method(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("=====Aspect处理=======");
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            System.out.println("参数为:" + arg);
        }
        long start = System.currentTimeMillis();
        Object object = pjp.proceed();
        System.out.println("Aspect 耗时:" + (System.currentTimeMillis() - start));
        return object;
    }

}
