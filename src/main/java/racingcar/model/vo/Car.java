package racingcar.model.vo;

public class Car implements Comparable<Car>{

    private final CarName carName;
    private final CarPosition carPosition;

    public Car(CarName carName, CarPosition carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public void carMove(int inputNumber) {
        for (int i = 0; i < inputNumber; i++) {
            carPosition.carMove(new RandomNumber().getMoveNumber());
        }
    }

    public CarName getCarName() {
        return carName;
    }

    public CarPosition getCarPosition() {
        return carPosition;
    }

    @Override
    public int compareTo(Car o) {
        return o.getCarPosition().getPosition() - getCarPosition().getPosition();
    }

    public String winnerCar(int maxPosition) {
        if (carPosition.getPosition() == maxPosition) {
            return getCarName().getName();
        }
        return "";
    }
}
