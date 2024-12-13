package com.feign.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Aspect
@Configuration
public class AOPLogging {

    private static final Logger logger = LoggerFactory.getLogger(AOPLogging.class);
    @Pointcut(value = "execution(* com.feign..*(..))")
    private void methodInsideReturnPointCut(){}

    @Around(value = "methodInsideReturnPointCut()")
    public Object loggingAdviceAroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();
        Object[] args = proceedingJoinPoint.getArgs();

        logger.info("Inside {} method of class {} with parameters :: {}", methodName, className, Arrays.deepToString(args));
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
        } catch (Throwable e) {
            logger.error("Exception occurred from Logging Aspect ", e);
            throw e;
        }
        logger.info("Returning from {} method of class {} with return value :: {}", methodName, className, result != null ? result.toString() : null);
        return result;
    }

}
