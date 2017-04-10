package com.apress.prospring4.ch5;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * Created by bobby on 3/31/2017.
 */
public class TestPointcut extends StaticMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, Class cls) {
        return ("advised".equals(method.getName()));
    }
}
