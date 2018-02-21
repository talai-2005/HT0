package com.nikolay.design.entity;

import com.nikolay.design.exception.IlluminanceTooMuchException;
import com.nikolay.design.exception.SpaceUsageTooMuchException;

import java.util.ArrayList;

public class Room {

    public final static int WINDOW_LIGHT = 700;
    private String name;
    private double square;
    private double minFullness;
    private double maxFullness;
    private double illumination;
    private int windows;
    private ArrayList<Subject> subjects = new ArrayList();


    public Room(String name, double square, int windows) {
        this.name = name;
        this.square = square;
        this.windows = windows;
        this.lightness = WINDOW_LIGHT * windows;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public int getWindows() {
        return windows;
    }

    public void setWindows(int windows) {
        this.windows = windows;
    }

    public double getMinFullness() {
        return minFullness;
    }

    public void setMinFullness(double minFullness) {
        this.minFullness = minFullness;
    }

    public double getMaxFullness() {
        return maxFullness;
    }

    public void setMaxFullness(double maxFullness) {
        this.maxFullness = maxFullness;
    }

    public double getLightness() {
        return lightness;
    }

    public void setLightness(double lightness) {
        this.lightness = lightness;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    public void add(Subject subject) throws SpaceUsageTooMuchException, IlluminanceTooMuchException {
        if (subject.getClass() == Other.class) {
            Other other = (Other) subject;
            if ((other.getMaxSquare() + maxFullness) <= square * 70 / 100) {
                minFullness = (other.getMinSquare() == 0) ? minFullness + other.getMaxSquare() : minFullness + other.getMinSquare();
                maxFullness += other.getMaxSquare();
                subjects.add(subject);
            } else {
                throw new SpaceUsageTooMuchException();
            }
        } else {
            Lamp lamp = (Lamp) subject;
            if ((lamp.getLight() + lightness) <= 4000){
                lightness += lamp.getLight();
                subjects.add(subject);
            }else {
                throw new IlluminanceTooMuchException();
            }
        }
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", square=" + square +
                ", windows=" + windows +
                ", subjects=" + subjects +
                '}';
    }
}
