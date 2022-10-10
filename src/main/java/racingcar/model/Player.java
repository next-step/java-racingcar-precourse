package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Player {
    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 9;

    private final Car car;

    public Player(Car car) {
        this.car = car;
    }

    public void drive() {
        car.run(createMovementScore());
    }

    public Car getCar() {
        return car;
    }

    public int createMovementScore() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
