package com.zzq.learn.ago.learn.test;

public interface FuncTest {

    void test(String s);

    default void test2(String s) {

    }

    default String test3() {
        return "";
    }
}
