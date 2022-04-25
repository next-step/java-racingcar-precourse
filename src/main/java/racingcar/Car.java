package racingcar;

public class Car {

    private final CarName name;
    private final Distance distance;

    public Car(CarName name, Distance distance) {
        this.name = name;
        this.distance = distance;
    }

    public int getDistance() {
        return distance.getValue();
    }

    public String getName() {
        return name.getValue();
    }

    public void drive(int value) {
        if (value >= Constants.THRESHOLD) {
            distance.increment();
        }
    }
}
