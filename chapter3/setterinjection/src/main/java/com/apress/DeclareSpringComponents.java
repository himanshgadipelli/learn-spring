package com.apress;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by bobby on 2/17/2017.
 */
public class DeclareSpringComponents {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-xml.xml");
        ctx.refresh();

        MessageRenderer messageRenderer = ctx.getBean("messageRenderer",
                MessageRenderer.class);
        messageRenderer.render();
    }
}
