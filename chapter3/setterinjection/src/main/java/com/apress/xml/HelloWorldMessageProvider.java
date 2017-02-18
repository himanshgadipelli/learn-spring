package com.apress.xml;

import com.apress.MessageProvider;

/**
 * Created by bobby on 2/17/2017.
 */
public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World!";
    }
}
