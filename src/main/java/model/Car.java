package model;

import view.InputView;

import java.util.Random;

public class Car {
    public String name;
    public int distance = 0;

    public Car(String name) {
        validateCarNames(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void move() {
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        if (randomNumber < 4) {
            return;
        }
        distance++;
    }


    private void validateCarNames(String name) {
        if  (name == null) {
            throw new IllegalArgumentException("[ERROR]name is empty");
        }
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException("[ERROR]name length must be between 1 and 5 ");
        }

    }


}
