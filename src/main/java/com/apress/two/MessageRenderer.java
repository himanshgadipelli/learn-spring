package com.apress.two;

/**
 * Created by bobby on 2/1/2017.
 */
public interface MessageRenderer {
    void render();
    void setMessageProvider(MessageProvider provider);
    MessageProvider getMessageProvider();
}
