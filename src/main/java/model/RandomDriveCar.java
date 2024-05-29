package model;

import java.util.Random;

public class RandomDriveCar implements Car {

    private final Random random;
    private final String name;
    private String state;

    public RandomDriveCar(String name) {
        this.random = new Random();
        this.name = name;
        this.state = "";
    }

    public RandomDriveCar(String name, Random random) {
        this.random = random;
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
