package racingcar.domain;

public class Car {

    public static final String DASH = "-";
    public static final int MINIMUM_MOVABLE_NUMBER = 4;
    public static final String EMPTY_STRING = "";

    private final String carName;
    private final StringBuilder distance = new StringBuilder(EMPTY_STRING);

    private Car(String carName) {
        this.carName = carName;
    }

    public static Car withName(String carName) {
        return new Car(carName);
    }

    public void moveByNumber(int number) {
        if (isUnderFour(number)) {
            return;
        }

        distance.append(DASH);
    }

    private boolean isUnderFour(int number) {
        return number < MINIMUM_MOVABLE_NUMBER;
    }

    public String getMovedDistance() {
        return distance.toString();
    }

    public String getName() {
        return this.carName;
    }
}
