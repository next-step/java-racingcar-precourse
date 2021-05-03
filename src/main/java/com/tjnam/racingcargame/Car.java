package com.tjnam.racingcargame;

public class Car implements Comparable<Car> {
    private CarName name;
    private CarPosition position;
    private MovementModerator movementModerator = new MovementModerator();
    
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

    public void printStatus(){
        System.out.print(name.getName() + " : ");
        for (int i=0 ; i<position.getPosition() ; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }

    public boolean judgeMove(){
        return movementModerator.canBeMove();
    }

    @Override
    public int compareTo(Car o) {
        return o.getPosition() - this.getPosition();
    }
}
