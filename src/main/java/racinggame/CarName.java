package racinggame;

public class CarName {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;
    private String carName;

    public CarName(String carName) {
        validateCarName(carName);
        this.carName = carName;
    }

    private void validateCarName(String carName) {
        if (carName.length() < MIN_NAME_LENGTH || carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("차 이름은 5자 이하만 가능합니다.");
        }
    }

    public String getValue() {
        return this.carName;
    }
}
