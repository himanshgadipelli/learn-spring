package com.apress;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by bobby on 2/17/2017.
 */
public class xmlConfigWithBeanFactory {
    public static void main(String[] args) {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader rdr = new XmlBeanDefinitionReader(factory);
        rdr.loadBeanDefinitions(new
                ClassPathResource("META-INF/spring/xml-bean-factory-config.xml"));
        Oracle oracle = (Oracle) factory.getBean("oracle");

        System.out.println(oracle.defineMeaningOfLife());
    }
}
