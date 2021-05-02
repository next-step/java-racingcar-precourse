package com.tjnam.racingcargame;

public class Car {
    private CarName name;
    private CarPosition position;
    
    public Car (CarName name) {
        this.name = name;
        this.position = new CarPosition();
    }

    public void moveCar(){
        position.move();
    }

    public String getCarName(){
        return this.name.getName();
    }

    public int getPosition(){
        return this.position.getPosition();
    }

}
