package com.zzq.learn.ago.learn.test;


public class GenericTest {

    <T, S extends StreamTest> T test(S s) {

        return (T) new OptionalTest();
    }

    <E> int insert(E e) {
        Class<?> clazz = e.getClass();

        return 0;
    }

    <E> E selectById(Integer id, Class<E> clazz) {

        selectMapper(id, clazz);
        insert(new Object());

        return (E) new Object();
    }


    <R, E> R selectMapper(Integer id, Class<E> clazz) {

        return (R) new Object();
    }

}
