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

    // 랜덤 값에 따라 전진하는 함수
    public void move(){
        boolean canMove = CarUtils.canMove();
        if(canMove){
            position++;
        }
    }
}
