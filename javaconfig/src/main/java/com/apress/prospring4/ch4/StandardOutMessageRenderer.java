package com.apress.prospring4.ch4;

/**
 * Created by bobby on 3/3/2017.
 */
public class StandardOutMessageRenderer implements MessageRenderer{
    private MessageProvider messageProvider;

    public void render(){
        if (messageProvider == null){
            throw new RuntimeException(
                    "You must set the property messageProvider of class: "
                    + StandardOutMessageRenderer.class
            );
        }

        System.out.println(messageProvider.getMessage());
    }

    @Override
    public MessageProvider getMessageProvider() {
        return messageProvider;
    }

    @Override
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }
}
