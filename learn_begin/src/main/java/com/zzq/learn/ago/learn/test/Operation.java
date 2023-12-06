package com.zzq.learn.ago.learn.test;

import com.zzq.learn.ago.learn.bean.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Operation {
    private double value1 = 0;
    private double value2 = 0;

    protected abstract double getResule();

    //加法
    public class Add extends Operation {
        @Override
        protected double getResule() {
            return getValue1() + getValue2();
        }
    }

    //减法
    public class Sub extends Operation {
        @Override
        protected double getResule() {
            return getValue1() - getValue2();
        }
    }

    //乘法
    public static class Mul extends User {
//        @Override
//        protected double getResule() {
//            return getValue1() * getValue2();
//        }
    }

    //除法
    public static class Div extends Operation {
        @Override
        protected double getResule() {
            if (getValue2() != 0) {
                return getValue1() / getValue2();
            }
            throw new IllegalArgumentException("除数不能为零");
        }
    }
}

