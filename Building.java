package com.nikolay.design.entity;

import java.util.LinkedHashSet;

public class Building {

    private String name;
    private LinkedHashSet<Room> rooms = new LinkedHashSet();

    public Building(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addRoom(String name, double square, int windows) {

        rooms.add(new Room(name, square, windows));
    }

    public Room getRoom(String name) {
        for (Room room : rooms) {
            if (room.getName().equals(name)) {
                return room;
            }
        }
        return null;
    }

    public void describe() {
        System.out.println(name);
        for (Room room : rooms) {
            System.out.print("\n" + room.getName() + "\n\n"
                    + "Освещённость = " + room.getLightness() + "(" + room.getWindows() + " окна по " + room.WINDOW_LIGHT + " лк");
            boolean isLampExists = room.getSubjects().stream().anyMatch(e -> e.getClass() == Lamp.class);
            if(isLampExists){
                System.out.print(", лампочки: ");
                for(Subject subject :room.getSubjects()){
                    if(subject.getClass() == Lamp.class){
                        Lamp lamp = (Lamp) subject;
                        System.out.print(lamp.getLight() + " лк ");
                    }
                }
            }
            System.out.print(")\n");
            if(room.getMaxFullness() != 0) {
                System.out.println("Площадь = " + room.getSquare() + " м^2 (занято " + room.getMinFullness() + "-" + room.getMaxFullness() + " м^2, гарантированно свободно " + (room.getSquare() - room.getMaxFullness()) + " м^2 или " + (room.getSquare() - room.getMaxFullness()) * 100 / room.getSquare() + "% площади)");
            }else{
                System.out.println("Площадь = " + room.getSquare() + " м^2 (свободно 100%)");
            }
            boolean isOtherExists = room.getSubjects().stream().anyMatch(e -> e.getClass() == Other.class);
            if(isOtherExists) {
                System.out.println("Мебель:");
                for (Subject subject : room.getSubjects()) {
                    if (subject.getClass() == Other.class) {
                        Other other = (Other) subject;
                        System.out.print(other.getName());
                        if (other.getMinSquare() != 0) {
                            System.out.print(" (площадь от " + other.getMinSquare() + " м^2 до " + other.getMaxSquare() + " м^2)");
                        } else {
                            System.out.print(" (площадь " + other.getMaxSquare() + " м^2)");
                        }
                        System.out.println();
                    }
                }
            }else{
                System.out.println("Мебели нет");
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
