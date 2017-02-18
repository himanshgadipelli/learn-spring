package com.apress.xml;

import com.apress.Bar;
import com.apress.Foo;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by bobby on 2/16/2017.
 */
public class Target {
    private Foo foo;
    private Foo foo2;
    private Bar bar;

    public Target() {
    }

    public Target (Foo foo){
        System.out.println("Target(fo) called");
    }

    public Target (Foo foo, Bar bar){
        System.out.println("Target(Foo, Bar) called");
    }

    public Foo getFoo() {
        return foo;
    }

    public void setFoo(Foo foo) {
        this.foo = foo;
        System.out.println("Property foo set");
    }

    public Foo getFoo2() {
        return foo2;
    }

    public void setFoo2(Foo foo2) {
        this.foo2 = foo2;
        System.out.println("Property foo2 set");
    }

    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
        System.out.println("Property bar set");
    }

    public static void main(String[] args){
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context.xml");
        ctx.refresh();

        Target t = null;

        System.out.println("Using byName:\n");
        t = (Target) ctx.getBean("targetByName");

        System.out.println("\nUsing byType:\n");
        t = (Target) ctx.getBean("targetByType");

        System.out.println("\nUsing constructor:\n");
        t = (Target) ctx.getBean("targetConstructor");
    }
}
