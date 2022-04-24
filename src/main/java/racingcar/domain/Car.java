package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final CarName carName;
    private int moveCount;
    private String moveResult;

    private Car(final CarName carName) {
        this.carName = carName;
        moveCount = 0;
        moveResult = carName.getName() + " : ";
    }

    static Car of(final CarName carName) {
        return new Car(carName);
    }

    public CarName getCarName() {
        return carName;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) > 3) {
            moveCount += 1;
            moveResult += "-";
        }
    }

    public void printMoveResult() {
        System.out.println(moveResult);
    }

}
