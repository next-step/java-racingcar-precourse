package racinggame.domain.car;

public class Car {
    private String carName;
    private int location = 0;
    private static final int CAR_NAME_LIMIT = 5;

    public Car(String carName) {
        this.carName = carName;
    }

    public void moveCar() {
        location++;
    }

    public static boolean isAvailableCarName(String carName) {
        int length = carName.length();
        return length > 0 && length <= CAR_NAME_LIMIT;
    }

    public static boolean canMoveCarByNum(int number) {
        return number > 3 && number < 10;
    }

    public String getCarName() {
        return carName;
    }

    public int getLocation() {
        return location;
    }
}
