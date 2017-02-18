package com.apress;

/**
 * Created by bobby on 2/2/2017.
 */
public class HelloWorldMessageProvider implements MessageProvider{
    @Override
    public String getMessage(){
        return "Hello World!";
    }
}
