package racinggame.model;

import nextstep.utils.Randoms;
import racinggame.utils.GameRule;

public class Car {
    String carName;
    int distance;

    public Car(String carName) {
        if (carName.length() > GameRule.MAX_CAR_NAME || carName.length() < GameRule.MIN_CAR_NAME) {
            throw new IllegalArgumentException();
        }

        this.carName = carName;
        distance = 0;
    }

    public String getCarName() {
        return carName;
    }

    public void decideMovement() {
        int randomNumber = Randoms.pickNumberInRange(GameRule.MIN_PICK_NUMBER, GameRule.MAX_PICK_NUMBER);

        if (randomNumber >= GameRule.MIN_FORWARD) {
            this.move();
        }
    }

    private void move() {
        distance++;
    }

    public String printCarInfo() {
        StringBuilder scoreboard = new StringBuilder();
        for (int i=0; i < distance; i++) {
            scoreboard.append(GameRule.SCORE_SHAPE);
        }
        return carName + " : " + scoreboard;
    }

}
