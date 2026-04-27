package org.example.arkbackend.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 方法返回值日志切面
 * 用于记录系统中所有方法的返回结果
 */
@Aspect
@Component
@Slf4j
public class AfterReturningAspect {

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
     * 后置返回通知：在方法执行完成并返回结果后执行
     * @param result 方法的返回结果
     */
    @AfterReturning(
            pointcut = "allPointcut()",
            returning = "result"
    )
    public void after(Object result) {
        log.info("【AfterReturning】返回结果：{}", result);
    }
}
