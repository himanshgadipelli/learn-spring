package com.apress;

/**
 * Created by bobby on 2/2/2017.
 */
public class CDLExample {
    public static void main(String[] args){
        Container container = new DefaultContainer();

        ManagedComponent managedComponent = new ContextualizedDependencyLookup();
        managedComponent.performLookup(container);

        System.out.println(managedComponent);
    }
}
