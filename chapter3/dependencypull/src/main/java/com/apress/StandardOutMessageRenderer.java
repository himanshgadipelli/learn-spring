package com.apress;

/**
 * Created by bobby on 2/2/2017.
 */
public class StandardOutMessageRenderer implements MessageRenderer {
    private MessageProvider messageProvider;

    @Override
    public void render() {
        if (messageProvider == null) {
            throw new RuntimeException("You must set the property messageProvider of class:"
                    + StandardOutMessageRenderer.class.getName());
        }

        System.out.println(messageProvider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider provider){
        this.messageProvider = provider;
    }

    @Override
    public MessageProvider getMessageProvider(){
        return this.messageProvider;
    }
}

