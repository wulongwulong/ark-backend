package org.example.arkbackend.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 服务层方法执行前的日志切面
 * 用于在服务层方法执行前输出日志
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    /**
     * 定义切点：匹配服务层所有方法
     * execution(* org.example.arkbackend.service..*.*(..)) 表示：
     * - *：任意返回类型
     * - org.example.arkbackend.service..*：service包及其子包下的所有类
     * - .*(..)：任意方法名，任意参数
     */
    @Pointcut("execution(* org.example.arkbackend.service..*.*(..))")
    public void servicePointcut() {}

    /**
     * 前置通知：在服务层方法执行前执行
     */
    @Before("servicePointcut()")
    public void before() {
        log.info("【Before】方法执行前");
    }

}
