package com.apress.prospring4.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Locale;

/**
 * Created by bobby on 3/3/2017.
 */
public class MessageSourceDemo {
    public static void main(String[] args){
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:/META-INF/spring/app-context-xml.xml");
        ctx.refresh();

        Locale english = Locale.ENGLISH;
        Locale czech = new Locale("cs", "CZ");

        System.out.println(ctx.getMessage("msg", null, english));
        System.out.print(ctx.getMessage("msg", null, czech));

        System.out.print(ctx.getMessage("nameMsg", new Object[] {"Chris", "Schaefer"}, english));
    }
}
