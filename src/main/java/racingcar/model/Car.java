package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.code.CarValueRange;

public class Car {
    private CarName carName;
    private int position = CarValueRange.INITIAL_CAR_POSITION.getCarValueRange();

    public Car(String carName) {
        this.carName = new CarName(carName);
    }

    public String getCarName() {
        return this.carName.getCarName();
    }

    public int getPosition() {
        return this.position;
    }

    public void moveOrStop() {
        int moveNumber = Randoms.pickNumberInRange(CarValueRange.MIN_NUMBER_RANGE.getCarValueRange(),
                CarValueRange.MAX_NUMBER_RANGE.getCarValueRange());
        if (isMoveNumber(moveNumber)) {
            moveForward();
        }
    }

    private boolean isMoveNumber(int number) {
        return number >= CarValueRange.CAR_MOVING_VALUE.getCarValueRange();
    }

    private void moveForward() {
        this.position++;
    }
}
