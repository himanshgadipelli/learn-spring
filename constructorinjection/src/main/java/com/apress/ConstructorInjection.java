package com.apress;

/**
 * Created by bobby on 2/2/2017.
 */
public class ConstructorInjection {
    private Dependency dependency;

    public ConstructorInjection(Dependency dependency){
        this.dependency = dependency;
    }

    @Override
    public String toString(){
        return dependency.toString();
    }
}
