package com.zzq.learn.ago.learn.design_pattern.decorator;

public class MiniCar implements Car {
    @Override
    public void move() {
        System.out.println("move 10m");
    }
}
