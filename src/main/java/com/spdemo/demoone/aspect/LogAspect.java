package com.spdemo.demoone.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author hp
 * @version 1.0
 * @description: ${description}
 * @Aspect 作用是把当前类标识为一个切面供容器读取
 * @Before 标识一个前置增强方法，相当于BeforeAdvice的功能
 * @AfterReturning 后置增强，相当于AfterReturningAdvice，方法退出时执行
 * @AfterThrowing 异常抛出增强，相当于ThrowsAdvice
 * @After final增强，不管是抛出异常或者正常退出都会执行
 * @Around 环绕增强，相当于MethodInterceptor
 * <p>
 * 各方法参数说明：
 * 除了@Around外，每个方法里都可以加或者不加参数JoinPoint，如果有用JoinPoint的地方就加，不加也可以，
 * JoinPoint里包含了类名、被切面的方法名，参数等属性，可供读取使用。
 * @Around参数必须为ProceedingJoinPoint，pjp.proceed相应于执行被切面的方法。
 * @AfterReturning方法里，可以加returning = “XXX”，XXX即为在controller里方法的返回值，
 * 本例中的返回值是“first controller”。@AfterThrowing方法里，可以加throwing = "XXX"，供读取异常信息
 * @date: 11:40 2018/9/28 0028
 */
@Aspect
@Component
@SuppressWarnings("all")
@Slf4j
public class LogAspect {
    @Pointcut("execution(public * com.spdemo.demoone.controller.*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void deBefore(JoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        log.info("方法之前执行 start...");
        log.info("URL: " + request.getRequestURL().toString());
        log.info("HTTP_METHOD: " + request.getMethod());
        log.info("IP: " + request.getRemoteAddr());
        log.info("CLASS_METHOD: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("ARGS: " + Arrays.toString(joinPoint.getArgs()));
        log.info("方法之前执行 end...");
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        log.info("方法的返回值: " + ret);
    }

    /**
     * 后置异常通知
     *
     * @param joinPoint
     */
    @AfterThrowing("webLog()")
    public void throwss(JoinPoint joinPoint) {
        log.info("方法异常时执行...");
    }

    /**
     * 后置异常通知，加异常信息返回值
     *
     * @param joinPoint
     * @param e
     */
//    @AfterThrowing(throwing = "e", pointcut = "webLog()")
//    public void throwssAddReturnException(JoinPoint joinPoint, Exception e) {
//        log.info("方法异常执行，返回异常信息...");
//    }


    /**
     * 后置最终通知，final增强，不管是抛出异常或者正常退出都会执行
     */
    @After("webLog()")
    public void after() {
        log.info("方法最后执行...");
    }

    /**
     * 环绕通知，环绕增强，相当于MethodInterceptor
     *
     * @param proceedingJoinPoint
     * @return
     */
    @Around("webLog()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        log.info("方法环绕 start ...");
        try {
            Object o = proceedingJoinPoint.proceed();
            log.info("方法环绕proceed,结果是: " + o);
            return o;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }


}
