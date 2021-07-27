package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.security.cert.CertificateRevokedException;
import java.time.LocalDate;
import java.util.Arrays;


@Aspect
@Component
public class BookAspect {

    //C1 :
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    @AfterReturning("execution(* com.example.controller.BookController.*(..))")
//    public void addMethodPointCut(JoinPoint joinPoint){
//        String className = joinPoint.getTarget().getClass().getSimpleName();
//        String methodName = joinPoint.getSignature().getName();
//        String args = Arrays.toString(joinPoint.getArgs());
//
//        logger.error("className : "+ className);
//        logger.error("methodName :"+ methodName);
//        logger.error("args" + args);
//    }

    //C2

    @Pointcut("execution(* com.example.controller.BookController.*(..))")
    public void addMethodPointCut() {
    }
    int count = 0;

    @Around("addMethodPointCut()")
    public Object aroundCallMethod(ProceedingJoinPoint proceedingJoinPoint) {
        Object value = null;

        try {
            value = proceedingJoinPoint.proceed();
            count++;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.err.println("  Time : " + LocalDate.now() +
                "   Count : " + count +
                "   Method : " + value
        );
        return value;
    }


}
