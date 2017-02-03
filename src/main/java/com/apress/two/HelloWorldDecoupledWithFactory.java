package com.apress.two;

/**
 * Created by bobby on 2/1/2017.
 */
public class HelloWorldDecoupledWithFactory {
    public static void main(String[] args){
        MessageRenderer mr = MessageSupportFactory.getInstance().getMessageRenderer();
        MessageProvider mp = MessageSupportFactory.getInstance().getMessageProvider();
        mr.setMessageProvider(mp);
        mr.render();
    }
}
