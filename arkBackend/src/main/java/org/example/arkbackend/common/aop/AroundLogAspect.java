package org.example.arkbackend.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 控制器方法执行环绕日志切面
 * 用于记录控制器方法的执行时间和返回结果
 */
@Aspect
@Component
@Slf4j
public class AroundLogAspect {

    /**
     * 定义切点：匹配控制器层所有方法
     * execution(* org.example.arkbackend.controller..*.*(..)) 表示：
     * - *：任意返回类型
     * - org.example.arkbackend.controller..*：controller包及其子包下的所有类
     * - .*(..)：任意方法名，任意参数
     */
    @Pointcut("execution(* org.example.arkbackend.controller..*.*(..))")
    public void controllerPointcut() {}

    /**
     * 环绕通知：在控制器方法执行前后执行
     * @param jp 连接点对象，用于获取方法信息和执行方法
     * @return 方法执行的返回结果
     * @throws Throwable 方法执行时抛出的异常
     */
    @Around("controllerPointcut()")
    public Object around(ProceedingJoinPoint jp) throws Throwable {

        // 记录方法开始执行时间
        long start = System.currentTimeMillis();
        // 获取方法签名信息
        String method = jp.getSignature().toShortString();

        try {
            // 执行目标方法
            Object result = jp.proceed();

            // 计算方法执行耗时
            long cost = System.currentTimeMillis() - start;

            // 输出方法执行信息
            log.info("【Around】{}，耗时：{}ms，返回：{}", method, cost, result);

            // 返回方法执行结果
            return result;

        } catch (Throwable e) {
            // 记录方法执行异常
            log.error("【Around异常】{}", method, e);
            // 重新抛出异常
            throw e;
        }
    }
}