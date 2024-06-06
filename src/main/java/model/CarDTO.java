package model;

import java.util.Random;

public class CarDTO {
    private final String name;
    private int movement;

    public CarDTO(String name) {
        this.name = name;
        this.movement = 0;
    }

    public String getName() {
        return name;
    }

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(0, 9);
    }

    public int getMovement() {
        return movement;
    }
}
