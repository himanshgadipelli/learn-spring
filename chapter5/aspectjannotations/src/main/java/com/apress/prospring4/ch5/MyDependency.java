package com.apress.prospring4.ch5;

import org.springframework.stereotype.Component;

/**
 * Created by bobby on 3/28/2017.
 */
@Component("myDependency")
public class MyDependency {
    public void foo(int intValue) {
        System.out.println("foo(int): " + intValue);
    }

    public void bar() {
        System.out.println("bar()");
    }
}
