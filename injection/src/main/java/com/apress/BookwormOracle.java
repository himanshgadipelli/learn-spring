package com.apress;

/**
 * Created by bobby on 2/3/2017.
 */
public class BookwormOracle implements Oracle{
    private Encyclopedia encyclopedia;

    public void setEncyclopedia(Encyclopedia encyclopedia){
        this.encyclopedia = encyclopedia;
    }

    @Override
    public String defineMeaningOfLife(){
        return "Encyclopedias are a waste of money - use the Internet!";
    }
}
