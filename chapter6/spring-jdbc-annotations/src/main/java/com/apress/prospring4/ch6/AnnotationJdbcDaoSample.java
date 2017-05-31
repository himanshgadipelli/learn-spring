package com.apress.prospring4.ch6;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by bobby on 4/11/2017.
 */
public class AnnotationJdbcDaoSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
        ctx.refresh();

        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
        System.out.println(contactDao.findAll());
    }
}
