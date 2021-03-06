package com.apress.prospring4.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;
/**
 * Created by bobby on 2/20/2017.
 */
public class MessageDigestFactoryExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context.xml");
        ctx.refresh();

        MessageDigester digester = (MessageDigester) ctx.getBean("digester");
        digester.digest("Hello World!");
    }
}
