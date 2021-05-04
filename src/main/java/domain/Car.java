package domain;


import static util.CarRacingConstants.CAR_NAME_MAX;
import static util.CarRacingConstants.CAR_NAME_MIN;

public class Car extends Moving {

    private final String carName;


    public Car(String carName) {
        hasSpaceInName(carName);
        isBetweenOneAndFive(carName);
        this.carName = carName;

    }


    public static void hasSpaceInName(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException();
        }
    }

    public static void isBetweenOneAndFive(String carName) {
        if (carName.length() < CAR_NAME_MIN || carName.length() > CAR_NAME_MAX) {
            throw new IllegalArgumentException();
        }
    }

    public String getCarName() {
        return carName;
    }

}
