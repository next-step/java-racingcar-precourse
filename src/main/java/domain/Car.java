package domain;

import java.util.Random;

public class Car {
    private String name;
    private int location = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void move(){
        if (getRandomNum() >= 4){
            location += 1;
        }
    }

    private int getRandomNum(){
        Random random = new Random();
        return random.nextInt(9);
    }
}
