package com.apress.prospring4.ch5;


import org.aspectj.lang.JoinPoint;

/**
 * Created by bobby on 3/28/2017.
 */
public class MyAdvice {
    public void simpleBeforeAdvice(JoinPoint joinPoint) {
        System.out.println("Executing: " +
                joinPoint.getSignature().getDeclaringTypeName() + " "
                + joinPoint.getSignature().getName());
    }
}
