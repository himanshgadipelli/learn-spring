package com.apress;

/**
 * Created by bobby on 2/17/2017.
 */
public interface NewsletterSender {
    void setSmtpServer(String smtpServer);
    String getSmtpServer();

    void setFromAddress(String fromAddress);
    String getFromAddress();

    void send();
}
