package com.apress.prospring4.ch4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by bobby on 3/3/2017.
 */
@Configuration
public class AppConfig {
    @Bean
    public MessageProvider messageProvider(){
        return new ConfigurableMessageProvider();
    }

    @Bean
    public MessageRenderer messageRenderer(){
        MessageRenderer renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(messageProvider());

        return renderer;
    }
}
