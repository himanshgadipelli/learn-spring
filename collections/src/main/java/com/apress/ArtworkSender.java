package com.apress;

/**
 * Created by bobby on 2/16/2017.
 */
public interface ArtworkSender {
    void sendArtwork(String artworkPath, Recipient recipient);
    String getFriendlyName();
    String getShortName();
}
