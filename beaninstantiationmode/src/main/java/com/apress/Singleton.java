package com.apress;

/**
 * Created by bobby on 2/16/2017.
 */
public class Singleton {
    private static Singleton instance;

    static {
        instance = new Singleton();
    }

    public static Singleton getInstance(){
        return instance;
    }
}
