package com.apress.prospring4.ch5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by bobby on 3/28/2017.
 */
@Component("myBean")
public class MyBean {
    private MyDependency myDependency;

    public void execute() {
        myDependency.foo(100);
        myDependency.foo(101);
        myDependency.bar();
    }

    @Autowired

    public void setMyDependency(MyDependency myDependency) {
        this.myDependency = myDependency;
    }
}
