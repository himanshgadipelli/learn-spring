package com.apress.prospring4.ch5;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by bobby on 3/28/2017.
 */
public class WeakKeyCheckAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method,
                               Object[] args, Object target) throws Throwable {
        if ((target instanceof KeyGenerator) && ("getKey".equals(method.getName()))) {
            long key = ((Long) returnValue).longValue();

            if (key == KeyGenerator.WEAK_KEY) {
                throw new SecurityException(
                        "Key Generator generated a weak key. Try again"
                );
            }
        }
    }
}
