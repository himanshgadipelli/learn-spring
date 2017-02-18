package com.apress.annotation;

import com.apress.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by bobby on 2/2/2017.
 */
@Service("messageProvider")
public class ConfigurableMessageProvider  implements MessageProvider{
    private String message;

    @Autowired
    public ConfigurableMessageProvider(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return this.message;
    }

}
