package com.apress;

/**
 * Created by bobby on 2/16/2017.
 */
public class FtpArtworkSender implements ArtworkSender {
    @Override
    public void sendArtwork(String artworkPath, Recipient recipient){
        //ftp logic here
    }

    @Override
    public String getFriendlyName(){
        return "File Transfer Protocol";
    }

    @Override
    public String getShortName(){
        return "ftp";
    }
}
