package com.apress.two;

/**
 * Created by bobby on 2/1/2017.
 */
public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage(){
        return "Hello World!";
    }
}
