package com.apress;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by bobby on 2/2/2017.
 */
public class DependencyPull {
    public static void  main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");

        MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
        mr.render();
    }
}
