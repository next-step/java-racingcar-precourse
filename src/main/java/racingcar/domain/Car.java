package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Objects;
import java.util.Observable;

public class Car extends Observable {
    public static final int LOWER_BOUND = 3;
    public static final int MINIMAL_NUMBER = 0;
    public static final int MAXIMAL_NUMBER = 9;
    private final CarName carName;
    private Status status;

    public Car(CarName carName) {
        this.carName = carName;
        this.status = Status.STOP;
    }

    public boolean isStopped() {
        return status == Status.STOP;
    }

    public void drive() {
        int number = Randoms.pickNumberInRange(MINIMAL_NUMBER, MAXIMAL_NUMBER);

        this.status = Status.GO;

        if (number <= LOWER_BOUND) {
            this.status = Status.STOP;
        }

        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return carName.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Car))
            return false;
        Car car = (Car) o;
        return Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
