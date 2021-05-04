package racingCar.domain;

public class Car {

    private final Name carName;
    private final Position position;

    public Car(String carName, int position) {
        this.carName = new Name(carName);
        this.position = new Position(position);
    }


}
