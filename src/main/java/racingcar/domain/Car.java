package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.common.Number;

import static racingcar.common.Number.MAX_RANDOM_NO;
import static racingcar.common.Number.MIN_RANDOM_NO;

public class Car {

    private final Name name;
    private final Distance distance;

    public Car(String name) {
        this.name = new Name(name);
        distance = new Distance(Number.ZERO);
    }

    public void move() {
        if (canMove()) {
            distance.increase();
        }
    }

    public boolean isMoveMoreThen(Car other) {
        return distance.isMoveMoreThen(other.distance);
    }

    public boolean isSameDistance(Car other) {
        return distance.isSameDistance(other.distance);
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NO, MAX_RANDOM_NO) >= CarState.MOVING_FORWARD.getNo();
    }

    public String getName() {
        return name.getName();
    }

    public int getDistance() {
        return distance.getDistance();
    }
}
