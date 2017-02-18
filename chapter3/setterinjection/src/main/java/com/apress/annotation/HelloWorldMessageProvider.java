package com.apress.annotation;

import org.springframework.stereotype.Service;
import com.apress.MessageProvider;

@Service("messageProvider")
public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World!";
    }
}
