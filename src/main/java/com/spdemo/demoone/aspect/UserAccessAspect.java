package com.spdemo.demoone.aspect;

import com.spdemo.demoone.aspect.annotation.UserAccess;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author hp
 * @version 1.0
 * @description: ${description}
 * @date: 14:22 2018/9/28 0028
 */
@Aspect
@Component
@Slf4j
public class UserAccessAspect {
    @Pointcut(value = "@annotation(com.spdemo.demoone.aspect.annotation.UserAccess)")
    public void access() {
    }

    @Before("access()")
    public void deBefore(JoinPoint joinPoint) throws Throwable {
        log.info("second before...");
    }

    @Around("@annotation(userAccess)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint, UserAccess userAccess) {
        log.info("second around: " + userAccess.desc());
        try {
            return proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }

    }


}
