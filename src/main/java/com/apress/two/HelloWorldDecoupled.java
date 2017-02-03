package com.apress.two;

/**
 * Created by bobby on 2/1/2017.
 */
public class HelloWorldDecoupled {
    public static void main(String[] args){
        MessageRenderer mr = new StandardOutMessageRenderer();
        MessageProvider mp = new HelloWorldMessageProvider();
        mr.setMessageProvider(mp);
        mr.render();
    }
}
