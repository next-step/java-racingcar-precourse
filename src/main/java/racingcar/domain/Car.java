package racingcar.domain;

import racingcar.utils.MathUtil;

public class Car {

    private CarName carName;

    private int position;

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int MIN_FORWARD = 4;

    public Car(CarName carName) {
        this.carName = carName;
        this.position = 0;
    }

    public CarName getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public void randomMove() {
        if (MIN_FORWARD <= MathUtil.randomNumber(MIN_NUMBER, MAX_NUMBER)) {
            this.position++;
        }
    }

}
