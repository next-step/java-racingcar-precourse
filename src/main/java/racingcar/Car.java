package racingcar;

public class Car {
    private final CarName carName;
    private Distance distance;

    private Car(CarName carName) {
        this.carName = carName;
        this.distance = Distance.createDistance();
    }

    public static Car createCar(CarName carName) {
        return new Car(carName);
    }

    public void goForward() {
        distance = distance.goForward();
    }

    public int getDistance() {
        return this.distance.getCurrentDistance();
    }

    public void goOrNot(int flag) {
        if (flag >= 4) {
            goForward();
        }
    }

    public String getCarNameString() {
        return this.carName.getString();
    }
}
