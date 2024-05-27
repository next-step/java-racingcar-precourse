package domain.race.model;

import domain.race.util.CarUtils;

public class Car {
    private int position = 0;
    private final String name;
    public Car(String name){
        this.name = name;
    }

    public int getPosition(){
        return this.position;
    }

    public String getName(){
        return this.name;
    }

    public void move(){
        boolean canMove = CarUtils.canMove();
        if(canMove){
            position++;
        }
    }
}
