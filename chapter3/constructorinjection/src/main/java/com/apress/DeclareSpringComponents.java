package com.apress;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by bobby on 2/2/2017.
 */
public class DeclareSpringComponents {
    public static void main(String[] args){
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
        ctx.refresh();

        MessageProvider messageProvider = ctx.getBean("messageProvider",
                MessageProvider.class);

        System.out.println(messageProvider.getMessage());
    }
}
