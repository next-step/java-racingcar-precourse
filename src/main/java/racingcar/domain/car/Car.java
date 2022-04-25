package racingcar.domain.car;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.RacingConstant;

public class Car {

    private CarName carName;
    private CarPosition carPosition;

    public Car(CarName carName, CarPosition carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public static Car of(CarName carName) {
        return new Car(carName, CarPosition.of(0));
    }

    public CarName getCarName() {
        return carName;
    }

    public int getCountByCarPosition() {
        return carPosition.getPosition();
    }

    public void move() {
        int number = Randoms.pickNumberInRange(RacingConstant.NUMBER_RANGE_MIN, RacingConstant.NUMBER_RANGE_MAX);
        if (number >= RacingConstant.NUMBER_RANGE_STANDARD) {
            carPosition.move();
        }
    }

}
