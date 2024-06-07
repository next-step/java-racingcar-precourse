package game.domain;

import game.config.constant.Rule;
import game.validator.CarNameValidator;
import java.util.Random;

public class Car {

    private String name;
    private int position;

    public Car(String name) {
        CarNameValidator.getInstance().validateNameLength(name);
        this.name = name;
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

    private boolean canMove() {
        Random random = new Random();
        return random.nextInt(Rule.MAX_RANDOM_VALUE + 1) >= Rule.MOVEMENT_THRESHOLD;
    }

}
