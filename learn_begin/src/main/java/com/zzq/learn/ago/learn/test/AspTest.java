package com.zzq.learn.ago.learn.test;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AspTest {

    @Before(value = "execution(* com.zzq.learn.ago.learn.test.Test.main())")
    public void aspect() {
        System.out.println("------------");
    }

}


