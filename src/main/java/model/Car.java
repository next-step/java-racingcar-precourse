package model;

import java.util.Random;

public class Car {

    private final String name;
    private int position;
    private static final Random rand = new Random();

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        int randomNumber = rand.nextInt(10);
        if (randomNumber >= 4) {
            position += 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getStatus() {
        return name + " : " + "-".repeat(position);
    }
}
