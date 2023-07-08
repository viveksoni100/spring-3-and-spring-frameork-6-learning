package com.vivek.learaop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {

    @Pointcut("execution(* com.vivek.learaop.*.*(..))")
    public void businessPackageConfig() {}

    @Pointcut("bean(*Service*)")
    public void businessPackageConfigUsingBean() {}

    @Pointcut("@annotation(com.vivek.learaop.annotations.TrackTime)")
    public void trackTimeAnnotation() {}
}
