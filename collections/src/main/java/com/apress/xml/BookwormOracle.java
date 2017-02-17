package com.apress.xml;

import com.apress.Oracle;

/**
 * Created by bobby on 2/16/2017.
 */

public class BookwormOracle implements Oracle {
    @Override
    public String defineMeaningOfLife(){
        return "Encyclopedias are a waste of money - use the Internet";
    }
}
