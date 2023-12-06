package com.zzq.learn.ago.learn.test;

import cn.hutool.json.JSONUtil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    static Integer[] array = {1, 7, 4, 6, 8, 3, 7, 7, 6, 3, null, null};
    static String[] strings = {"啦啦", "dsa", "test", "一二"};
    static Stream<Integer> iStream = Stream.of(array);
    static Stream<String> sStream = Stream.of(strings);

    public static void main(String[] args) {
//        iStream.sorted().forEach(System.out::println);
//        System.out.println(sStream.reduce(String::concat).get());
//        iStream.filter(i -> i>3).forEach(System.out::println);
//        System.out.println(iStream.max(Integer::compareTo));
//        Optional<Integer> max = iStream.max(Integer::compareTo);
//        if (max.isPresent()){
//            Integer integer = max.get();
//        }
//        iStream.distinct().filter(Objects::nonNull).forEach(System.out::println);
        List<Integer> list = Arrays.asList(array);
        list = list.stream().distinct().filter(Objects::nonNull).sorted().collect(Collectors.toList());
        System.out.println(list);
    }


    public void test2() {

        Integer[] array = {1, 7, 4, 6, 8, 3};
        Arrays.stream(array).forEach(integer -> integer += 1);
        Arrays.stream(array).forEach(System.out::println);
        Stream<Integer> stream = Arrays.stream(array);
        List<Integer> collect = stream.sorted(Integer::compareTo).collect(Collectors.toList());

        JSONUtil.parseObj("").forEach((k, v) -> {

        });

        List<Integer> collect1 = stream.map(el -> el + 1).collect(Collectors.toList());
        List<Integer> collect2 = stream.filter(el -> el > 10).collect(Collectors.toList());
        List<Integer> collect3 = stream.limit(10).collect(Collectors.toList());
        boolean b5 = stream.allMatch(el -> el == 1);
        boolean b1 = stream.anyMatch(el -> el == 17);
        List<Integer> collect4 = stream.distinct().collect(Collectors.toList());

        Optional<Integer> max = stream.max(Comparator.naturalOrder());

        Integer[] integers = Optional.of(array).orElse(new Integer[]{});
        Integer[] integers1 = Optional.of(array).filter(s -> s.length < 4).orElse(new Integer[]{1, 2, 3});
        Integer integer = stream.reduce((a, b) -> a * b).orElse(0);
        stream.forEach(System.out::println);

    }
}
