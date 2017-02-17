package com.apress.annotation;

import com.apress.Oracle;
import org.springframework.stereotype.Service;

/**
 * Created by bobby on 2/16/2017.
 */
@Service
public class BookwormOracle implements Oracle {
    @Override
    public String defineMeaningOfLife(){
        return "Encyclopedias are a waste of money - use the Internet";
    }
}
