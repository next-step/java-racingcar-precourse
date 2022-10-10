package racingcar.domain.car;

public class Car {

    private static final int CAR_MOVE_DISTANCE = 1;

    private CarName carName;
    private CarPosition position;

    public Car(CarName carName, CarPosition position) {
        this.carName = carName;
        this.position = position;
    }

    public static Car createCar(String name) {
        return new Car(CarName.createCarName(name), CarPosition.createNewCarPosition());
    }

    public void playRound(CarStatus carStatus) {
        if (CarStatus.isMoveStatus(carStatus)) {
            position.move(CAR_MOVE_DISTANCE);
        }
    }

    public CarPosition getPosition() {
        return position;
    }

    public CarName getName() {
        return carName;
    }
}
