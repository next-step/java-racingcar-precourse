package racinggame;

public class CarName {
    private final int CAR_NAME_MAX_SIZE = 5;
    private String carName;

    public CarName(String carName) {
        if (carName.length() > CAR_NAME_MAX_SIZE) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하여야됩니다.");
        }
        this.carName = carName;
    }


    public static CarName of(String carName) {
        return new CarName(carName);
    }

    public String getCarName() {
        return this.carName;
    }
}
