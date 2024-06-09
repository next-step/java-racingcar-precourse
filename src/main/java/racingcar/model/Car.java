package racingcar.model;

import java.util.Random;

public class Car {
    private static final int MINIMUM_NUM = 4;
    private String name;
    private int position = 0;

    public Car(String name){
        this.name = name;
    }

    public void move(){
        if(canMove()){
            position++;
        }
    }

    private boolean canMove() {
        Random random = new Random();
        return random.nextInt(10) >= MINIMUM_NUM;
    }

    public int getPosition(){
        return position;
    }

    public String getName(){
        return name;
    }
}
