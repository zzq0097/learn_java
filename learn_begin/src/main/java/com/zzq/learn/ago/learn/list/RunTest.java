package com.zzq.learn.ago.learn.list;

import java.util.Arrays;
import java.util.LinkedList;

public class RunTest {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 5, 2, 7, 3, 6));
//        list.offer(5);
        list.push(5);
        System.out.println(list);
    }
}
