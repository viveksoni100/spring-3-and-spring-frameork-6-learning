package com.vivek.learaop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Aspect
@Configuration
public class LoggingAspect {

    @Before("com.vivek.learaop.aspect.CommonPointcutConfig.businessPackageConfig()")
    public void logMethodCallBefore(JoinPoint point) {
        log.info("Method is called before - {}", point);
    }

    @After("com.vivek.learaop.aspect.CommonPointcutConfig.businessPackageConfig()")
    public void logMethodCallAfter(JoinPoint point) {
        log.info("Method is called after - {}", point);
    }

    @AfterThrowing(pointcut = "com.vivek.learaop.aspect.CommonPointcutConfig.businessPackageConfig()", throwing = "exception")
    public void logMethodCallAfterError(JoinPoint point, Exception exception) {
        log.info("Method is called after error - {} - {}", point, exception);
    }
}
