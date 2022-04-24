package racingcar.domain;

public class CarName {

    private final String carName;

    private CarName(String carName) {
        this.carName = carName;
    }

    static CarName of(final String carName) {
        validateCarName(carName);
        return new CarName(carName);
    }

    private static void validateCarName(String carName) {
        if (carName.length() < 1 || carName.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_EMPTY_OR_LENGTH_OVER_FIVE.getMessage());
        }
    }

    public String getName() {
        return carName;
    }

}
