package race.model;

import race.exception.LengthLimitException;

public class Car {
    static final int CAR_NAME_LENGTH_LIMIT = 5;
    private String carName;
    private int position;


    public Car(String carName, int position) {
        validateCarName(carName);
        this.carName = carName;
        this.position = position;
    }

    private void validateCarName(String carName) {
        if (carName.length() > CAR_NAME_LENGTH_LIMIT)
            throw new LengthLimitException();
    }
}
