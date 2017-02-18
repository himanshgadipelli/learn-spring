package com.apress;

/**
 * Created by bobby on 2/9/2017.
 */
public class ReplacementTarget {
    public String formatMessage(String msg){
        return "<h1>" + msg +"</h1>";
    }

    public String formatMessage(Object msg){
        return "<h1>" + msg +"</h1>";
    }
}
