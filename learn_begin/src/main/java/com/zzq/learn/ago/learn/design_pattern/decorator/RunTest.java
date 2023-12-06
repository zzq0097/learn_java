package com.zzq.learn.ago.learn.design_pattern.decorator;

public class RunTest {
    public static void main(String[] args) {
        MiniCar miniCar = new MiniCar();
        miniCar.move();

        FlyCarDecorator flyCar = new FlyCar(miniCar);
        flyCar.move();
        flyCar.fly();
    }
}
