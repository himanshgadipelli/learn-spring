package com.apress.prospring4.ch4;

/**
 * Created by bobby on 3/3/2017.
 */
public class ConfigurableMessageProvider implements MessageProvider {
    private String message = "Default message";

    public ConfigurableMessageProvider(){

    }

    public ConfigurableMessageProvider(String message){
        this.message = message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
