package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {

    private CarName carName;
    private CarPosition carPosition;

    public Car(String name) {
        carName = new CarName(name);
        carPosition = new CarPosition();
    }

    public boolean tryMoving() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            carPosition.incrementPosition();
            return true;
        }

        return false;
    }

    public String getName() {
        return carName.getName();
    }

    public int getPosition() {
        return carPosition.getPosition();
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.getPosition(), o.getPosition());
    }
}
