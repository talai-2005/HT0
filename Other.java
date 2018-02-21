package com.nikolay.design.entity;

public class Other implements Subject  {

    private String name;
    private double minSquare;
    private double maxSquare;

    public Other(String name, double maxSquare) {
        this.name = name;
        this.maxSquare = maxSquare;
    }

    public Other(String name, double minSquare, double maxSquare) {
        this.name = name;
        this.minSquare = minSquare;
        this.maxSquare = maxSquare;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMinSquare() {
        return minSquare;
    }

    public void setMinSquare(double minSquare) {
        this.minSquare = minSquare;
    }

    public double getMaxSquare() {
        return maxSquare;
    }

    public void setMaxSquare(double maxSquare) {
        this.maxSquare = maxSquare;
    }

    @Override
    public String toString() {
        return "Other{" +
                "name='" + name + '\'' +
                ", minSquare=" + minSquare +
                ", maxSquare=" + maxSquare +
                '}';
    }
}
