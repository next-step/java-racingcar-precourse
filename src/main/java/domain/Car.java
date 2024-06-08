package domain;

import static utils.ErrorConstants.OVER_FIVE_WORDS;

public class Car {
    private final String carName;
    private int position;

    public Car(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(OVER_FIVE_WORDS + carName);
        }
        this.carName = carName;gitg
        this.position = 0;
    }

    public void moveCar() {
        int randomNumber = (int) (Math.random() * 10);
        if (randomNumber >= 4) {
            position++;
        }
    }
}
