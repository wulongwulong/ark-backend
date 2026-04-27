package org.example.arkbackend.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 异常处理切面
 * 用于捕获并记录系统中所有方法执行时抛出的异常
 */
@Aspect
@Component
@Slf4j
public class AfterThrowingAspect {

    /**
     * 定义切点：匹配系统中所有方法
     * execution(* org.example.arkbackend..*(..)) 表示：
     * - *：任意返回类型
     * - org.example.arkbackend..*：arkbackend包及其子包下的所有类
     * - .*(..)：任意方法名，任意参数
     */
    @Pointcut("execution(* org.example.arkbackend..*(..))")
    public void allPointcut() {}

    /**
     * 异常通知：在方法抛出异常后执行
     * @param e 方法抛出的异常对象
     */
    @AfterThrowing(
            pointcut = "allPointcut()",
            throwing = "e"
    )
    public void error(Throwable e) {
        log.error("【AfterThrowing】异常：", e);
    }
}