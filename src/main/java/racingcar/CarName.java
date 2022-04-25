package racingcar;

public class CarName {
    private final String ERROR_NAME_LENGTH_LIMIT = "[ERROR] 이름은 5글자 이하여야 합니다.";

    private final String carName;

    private CarName(String carName) {
        validateCarName(carName);
        this.carName = carName;
    }

    public static CarName createCarName(String inputName) {
        return new CarName(inputName);
    }

    private void validateCarName(String name) {
        if (name.length() > 5 || name.length() == 0) {
            throw new IllegalArgumentException(ERROR_NAME_LENGTH_LIMIT);
        }
    }

    public String getString() {
        return this.carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarName carName1 = (CarName) o;

        return carName.equals(carName1.carName);
    }

    @Override
    public int hashCode() {
        return carName.hashCode();
    }
}
