package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final String STRING_FORMAT = "%s : %s";
    private static final int RANDOM_MIN_NUMBER = 0;
    private static final int RANDOM_MAX_NUMBER = 9;
    private static final int MOVE_BASE_NUMBER = 4;

    private CarName carName;
    private Position position;

    public Car(String name) {
        this.carName = new CarName(name);
        this.position = new Position();
    }

    public Car(CarName name) {
        this.carName = name;
        this.position = new Position();
    }

    public String getCarNameValue() {
        return this.carName.getName();
    }

    public int getPositionValue() {
        return this.position.getPosition();
    }

    public void movePosition() {
        position.addOnePosition();
    }

    public void tryMovePosition() {
        if (Randoms.pickNumberInRange(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER) >= MOVE_BASE_NUMBER) {
            movePosition();
        }
    }

    public String carStatus() {
        return String.format(STRING_FORMAT, getCarNameValue(), position.positionStatus());
    }
}
