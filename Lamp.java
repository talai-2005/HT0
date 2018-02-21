package com.nikolay.design.entity;

public class Lamp implements Subject {

    private int light;

    public Lamp(int light) {
        this.light = light;
    }

    public int getLight() {
        return light;
    }

    public void setLight(int light) {
        this.light = light;
    }

    @Override
    public String toString() {
        return "Lamp{" +
                "light=" + light +
                '}';
    }
}
