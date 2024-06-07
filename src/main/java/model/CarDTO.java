package model;

import java.util.Random;

public class CarDTO {
    private final String name;

    public CarDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(0, 9);
    }

}
