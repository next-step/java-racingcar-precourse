package racingcar.model;

public class CarName {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private final String carName;

    public CarName(String carName) {
        validateCarNameLength(carName);
        this.carName = carName;
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 최대 5자 까지 가능하다.");
        }

        if (carName.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 공백이 될 수 없다.");
        }
    }

    public String getCarName() {
        return carName;
    }

}
