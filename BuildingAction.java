package com.nikolay.design.action;

import com.nikolay.design.entity.Building;
import com.nikolay.design.entity.Lamp;
import com.nikolay.design.entity.Other;
import com.nikolay.design.exception.IlluminanceTooMuchException;
import com.nikolay.design.exception.SpaceUsageTooMuchException;

public class BuildingAction {

    public static void main(String[] args) {
        try {
            Building building = new Building("Здание 1");
            building.addRoom("Комната 1", 100, 3);
            building.addRoom("Комната 2", 5, 2);
            building.getRoom("Комната 1").add(new Lamp(150));
            building.getRoom("Комната 1").add(new Lamp(250));
            building.getRoom("Комната 1").add(new Other("Стол письменный", 3));
            building.getRoom("Комната 1").add(new Other("Кресло мягкое и пушистое", 1, 2));
            building.describe();
        }catch(SpaceUsageTooMuchException | IlluminanceTooMuchException ex){
            ex.printStackTrace();
        }
    }
}
