package com.apress.prospring4.ch6;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by bobby on 4/24/2017.
 */
public class JdbcContactDaoSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-xml.xml");
        ctx.refresh();

        ContactDao contactDao = ctx.getBean("ContactDao", ContactDao.class);

        System.out.println("First name for contact id 1 is: " +
                contactDao.findFirstNameById((long) 11));
    }
}
