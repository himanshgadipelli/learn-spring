package com.apress.xml;

import com.apress.MessageProvider;

/**
 * Created by bobby on 2/2/2017.
 */
public class ConfigurableMessageProvider implements MessageProvider {
    private String message;

    public ConfigurableMessageProvider(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
