package com.apress;

/**
 * Created by bobby on 2/17/2017.
 */
public interface MessageRenderer {
    void render();
    void setMessageProvider(MessageProvider provider);
    MessageProvider getMessageProvider();
}
