package game.domain;

import game.config.constant.Rule;
import game.validator.CarNameValidator;
import java.util.Objects;
import java.util.Random;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        CarNameValidator.getInstance().validateNameLength(name);
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int move() {
        if(canMove()) {
            this.position++;
        }
        return this.position;
    }

    public int move(int randomValue) {
        if(canMove(randomValue)) {
            this.position++;
        }
        return this.position;
    }

    private boolean canMove() {
        Random random = new Random();
        return random.nextInt(Rule.MAX_RANDOM_VALUE + 1) >= Rule.MOVEMENT_THRESHOLD;
    }

    private boolean canMove(int randomValue) {
        return randomValue >= Rule.MOVEMENT_THRESHOLD;
    }

}
