package com.apress.prospring4.ch4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by bobby on 3/3/2017.
 */
public class JavaConfigXMLExample {
    public static void main(String[] args) {
        ApplicationContext ctx = new
                ClassPathXmlApplicationContext("classpath:META-INF/spring/app-context-xml.xml");

        MessageRenderer renderer =
                ctx.getBean("messageRenderer", MessageRenderer.class);

        renderer.render();
    }
}
