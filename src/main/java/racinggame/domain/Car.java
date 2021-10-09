package racinggame.domain;

public class Car {

    private CarName carName;

    public Car(CarName carName) {
        validateName(carName);
        this.carName = carName;
    }

    public CarName getCarName() {
        return carName;
    }

    public static Car of(CarName carName) {
        return new Car(carName);
    }


    public static void validateName(CarName carName) {
       validateNullOrEmptyName(carName);
       validateExceededName(carName);
    }

    public static void validateNullOrEmptyName(CarName carName) {
        if ("".equals(carName) || carName == null) {
            throw new IllegalArgumentException(ErrorCode.NAME_NOT_BLANK.getMessage());
        }
    }

    public static void validateExceededName(CarName carName) {
        if (carName.getName().length() > 5) {
            throw new IllegalArgumentException(ErrorCode.NAME_EXCEEDED.getMessage());
        }
    }
}
