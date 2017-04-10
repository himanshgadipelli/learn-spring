package com.apress.prospring4.ch5;

import org.springframework.aop.support.DefaultIntroductionAdvisor;

/**
 * Created by bobby on 4/2/2017.
 */
public class IsModifiedAdvisor extends DefaultIntroductionAdvisor {
    public IsModifiedAdvisor() {
        super(new IsModifiedMixin());
    }
}
