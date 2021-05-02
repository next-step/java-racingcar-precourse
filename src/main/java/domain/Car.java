package domain;

import static util.CarRacingConstants.CAR_START_POS;

public class Car {

    private String carName;
    private int pos;

    public Car(String carName) {
        hasSpaceInName(carName);
        isBetweenOneAndFive(carName);
        this.carName = carName;
        this.pos = CAR_START_POS;
    }

    public static void hasSpaceInName(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException();
        }
    }

    public static void isBetweenOneAndFive(String carName) {
        if (carName.length() < 1 || carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

}
