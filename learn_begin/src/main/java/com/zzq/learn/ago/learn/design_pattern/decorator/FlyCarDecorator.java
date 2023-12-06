package com.zzq.learn.ago.learn.design_pattern.decorator;

public abstract class FlyCarDecorator implements Car {
    protected Car car;

    public FlyCarDecorator(Car car) {
        this.car = car;
    }

    @Override
    public void move() {
        car.move();
    }

    public void fly() {
        System.out.println("fly 5000m");
    }
}
