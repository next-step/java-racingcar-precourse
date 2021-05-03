package racingcargame.domain;

import racingcargame.utility.Utility;

public class Car {
    public static final int MOVE_THRESHOLD = 4;
    public static final int MILEAGE_INITIAL_VALUE = 0;
    public static final String NAME_DELIMITER = ":";
    public static final String PROGRESS_BAR = "-";
    CarName carName;
    Mileage mileage;

    private Car(CarName carName) {
        this.carName = carName;
        this.mileage = Mileage.of(MILEAGE_INITIAL_VALUE);
    }

    public static Car of(CarName carName) {
        return new Car(carName);
    }

    public void move(Integer input) {
        if (input >= MOVE_THRESHOLD) {
            mileage.addOne();
        }
    }

    public void randomMove() {
        move(Utility.generateRandomSingleDigitInteger());
    }

    public CarName getCarName() {
        return carName;
    }

    public Mileage getMileage() {
        return mileage;
    }

    public String getResultString() {
        StringBuilder resultStringBuilder = new StringBuilder();
        resultStringBuilder.append(carName.getCarName());
        resultStringBuilder.append(NAME_DELIMITER);
        for (int i = 0; i < mileage.getMileage(); i++) {
            resultStringBuilder.append(PROGRESS_BAR);
        }
        resultStringBuilder.append(System.lineSeparator());
        return resultStringBuilder.toString();
    }
}
