package com.apress.prospring4.ch5;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by bobby on 3/28/2017.
 */
public class AopNamespaceExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-xml.xml");
        ctx.refresh();

        MyBean myBean = (MyBean) ctx.getBean("myBean");
        myBean.execute();
    }
}
