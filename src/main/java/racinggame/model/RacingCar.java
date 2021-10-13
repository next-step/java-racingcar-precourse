package racinggame.model;

import nextstep.utils.Randoms;

import static racinggame.constants.RacingCarConstants.MOVE_MAX_NUM;
import static racinggame.constants.RacingCarConstants.MOVE_MIN_NUM;

public class RacingCar {
    private final CarName carName; // Wrapping
    private final CarPosition carPosition; // Wrapping

    private RacingCar(CarName carName) {
        this.carName = carName;
        this.carPosition = new CarPosition();
    }

    public static RacingCar newInstance(String carName) {
        RacingCar car = new RacingCar(new CarName(carName.trim()));
        return car;
    }

    public int moveForwardRacingCar(int moveConditionNum) {    // private to public for test
        return this.carPosition.moveRacingCarCondition(moveConditionNum);
    }

    public int moveForwardRacingCar() {
        int moveConditionNum = Randoms.pickNumberInRange(MOVE_MIN_NUM, MOVE_MAX_NUM);
        return moveForwardRacingCar(moveConditionNum);
    }

    public String getRacingCarName() {
        return carName.getName();
    }

    public int getRacingCarPosition() {
        return carPosition.getMoveCount();
    }

    @Override
    public String toString() {
        return this.getRacingCarName() + " : " + this.getRacingCarPosition();
    }
}