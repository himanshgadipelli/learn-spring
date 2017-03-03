package com.apress.prospring4.ch4;

/**
 * Created by bobby on 3/3/2017.
 */
public interface MessageRenderer {
    void render();
    void setMessageProvider(MessageProvider provider);
    MessageProvider getMessageProvider();
}
