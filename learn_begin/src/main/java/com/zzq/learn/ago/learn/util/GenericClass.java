package com.zzq.learn.ago.learn.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class GenericClass<T> {
    private Class<T> type;

    public GenericClass() {
        Type superClass = getClass().getGenericSuperclass();
        if (superClass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) superClass;
            Type[] typeArguments = parameterizedType.getActualTypeArguments();
            this.type = (Class<T>) typeArguments[0];
        }
    }

    public Class<T> getType() {
        return type;
    }


    public static void main(String[] args) {
        GenericClass<String> myClass = new GenericClass<String>() {
        };
        Class<String> type = myClass.getType(); // 返回String.class
        System.out.println(type);
    }
}
