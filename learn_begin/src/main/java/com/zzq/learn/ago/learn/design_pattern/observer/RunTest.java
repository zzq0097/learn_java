package com.zzq.learn.ago.learn.design_pattern.observer;

public class RunTest {
    public static void main(String[] args) {
        AbstractRectangle abstractRectangle = new AbstractRectangle(1, 2) {
            @Override
            public Integer getArea() {
                return super.getArea();
            }
        };

    }
}
