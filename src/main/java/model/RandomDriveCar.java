package model;

import java.util.Random;

public class RandomDriveCar implements Car {

    private static final Random random = new Random();

    private final String name;
    private String state;

    public RandomDriveCar(String name) {
        this.name = name;
        this.state = "";
    }

    @Override
    public String drive() {
        int randomNumber = random.nextInt(9);
        if (randomNumber >= 4) {
            state += "-";
        }
        return state;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }
}
