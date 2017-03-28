package com.apress;

import org.springframework.context.ApplicationEvent;

/**
 * Created by bobby on 2/17/2017.
 */
public class MessageEvent extends ApplicationEvent{
    private String msg;
    public MessageEvent(Object source, String msg){
        super(source);
        this.msg = msg;
    }

    public String getMessage() {
        return msg;
    }
}
