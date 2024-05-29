package race.model;

import race.exception.LengthLimitException;

public class Car {
    static final int CAR_NAME_LENGTH_LIMIT = 5;
    private String carName;
    private int position;


    public Car(String carName) {
        validateCarName(carName);
        this.carName = carName;
        this.position = 0;
    }

    private void validateCarName(String carName) {
        if (carName.length() > CAR_NAME_LENGTH_LIMIT)
            throw new LengthLimitException();
    }

    public void moveForward() {
        position += 1;
    }

    public int getPosition() {
        return position;
    }
}
