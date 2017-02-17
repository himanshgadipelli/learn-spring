package com.apress;

/**
 * Created by bobby on 2/9/2017.
 */
public abstract class AbstractLookupDemoBean implements DemoBean{
    public abstract MyHelper getMyHelper();

    @Override
    public void someOperation(){
        getMyHelper().doSomethingHelpful();
    }
}
