package racinggame.domain;

import java.util.Random;
import racinggame.validator.RacingGameInputValidator;

public class Car {
    private String name;
    private int position = 0;
    private Random random = new Random();

    public Car(String name){
        this.position = position;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private boolean canMove(){
        return random.nextInt(10) >= 4;
    }
    public void move() {
        if(canMove()){
            position++;
        }
    }
}
