package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Racer {
    public static final int MIN_PICK_NUMBER = 0;
    public static final int MAX_PICK_NUMBER = 9;

    private final Car car;

    public Racer(Car car) {
        this.car = car;
    }

    public void drive() {
        car.run(createMovementScore());
    }

    public Car getCar() {return car;}

    public int createMovementScore() {
        return Randoms.pickNumberInRange(MIN_PICK_NUMBER, MAX_PICK_NUMBER);
    }
}
