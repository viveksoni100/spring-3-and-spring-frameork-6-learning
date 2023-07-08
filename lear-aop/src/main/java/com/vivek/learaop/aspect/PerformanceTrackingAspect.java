package com.vivek.learaop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Aspect
@Configuration
public class PerformanceTrackingAspect {

//    @Around("com.vivek.learaop.aspect.CommonPointcutConfig.businessPackageConfig()")
    @Around("com.vivek.learaop.aspect.CommonPointcutConfig.trackTimeAnnotation()")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object returnValue = proceedingJoinPoint.proceed();

        long endTime = System.currentTimeMillis();

        long executionDuration = endTime - startTime;

        log.info("Around aspect - {} Method executed in {} ms", proceedingJoinPoint, executionDuration);

        return returnValue;
    }
}
