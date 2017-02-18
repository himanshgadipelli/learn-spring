package com.apress;

/**
 * Created by bobby on 2/17/2017.
 */
public class SetterInjection {
    private Dependency dependency;

    public void setDependency(Dependency dependency){
        this.dependency = dependency;
    }

    @Override
    public String toString(){
        return dependency.toString();
    }
}
