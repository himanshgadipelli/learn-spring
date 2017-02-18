package com.apress;

import org.springframework.beans.factory.BeanNameAware;

/**
 * Created by bobby on 2/17/2017.
 */
public class BeanNamePrinter implements BeanNameAware {
    private String beanName;

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public void someOperation() {
        System.out.println("Bean [" + beanName + "] - someOperation()");
    }
}
