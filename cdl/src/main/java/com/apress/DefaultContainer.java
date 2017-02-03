package com.apress;

/**
 * Created by bobby on 2/2/2017.
 */
public class DefaultContainer implements Container {
    @Override
    public Object getDependency(String key){
        if("myDependency".equals(key)){
            return new Dependency();
        }

        throw new RuntimeException("Unknown dependency " + key);
    }
}
