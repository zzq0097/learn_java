package com.zzq.learn.ago.learn.design_pattern.observer;

public abstract class AbstractRectangle implements Rectangle {
    private final Integer length;
    private final Integer width;

    public AbstractRectangle(Integer length, Integer width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public Integer getArea() {
        return length * width;
    }
}
