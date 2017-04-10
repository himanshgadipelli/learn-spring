package com.apress.prospring4.ch5;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by bobby on 3/31/2017.
 */
public class SimpleBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object object) throws Throwable{
        System.out.println("Before method: " + method);
    }
}
