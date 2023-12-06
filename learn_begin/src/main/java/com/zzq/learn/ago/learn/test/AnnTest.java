package com.zzq.learn.ago.learn.test;

public @interface AnnTest {
    enum value {NAME, AGE}

    ;

    String value() default "";
}
