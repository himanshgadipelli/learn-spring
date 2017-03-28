package com.apress.prospring4.ch5;

/**
 * Created by bobby on 3/28/2017.
 */
public class MyDependency {
    public void foo(int intValue){
        System.out.println("foo(int): " + intValue);
    }

    public void bar(){
        System.out.println("bar()");
    }
}
