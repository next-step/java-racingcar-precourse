package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    public static final Integer MIN_MOVE_COUNT = 0;
    public static final Integer MAX_MOVE_COUNT = 9;
    public static final Integer MOVE_STANDARD_COUNT = 4;
    public static final Integer MIN_NAME_LENGTH = 1;
    public static final Integer MAX_NAME_LENGTH = 5;
    public static final Boolean MOVE = true;
    private String name;
    private Integer moveCount;
    private Boolean moveOrStop;
    private Integer carPosition;

    public Car(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1글자 이상, 5글자 이하만 가능합니다.");
        }
        this.name = name;
        this.carPosition = 0;
        this.moveCount = 0;
        this.moveOrStop = Boolean.FALSE;
    }

    public String getName() {
        return this.name;
    }

    public Integer getMoveCount() {
        return this.moveCount;
    }

    public void setMoveCount() {
        this.moveCount = Randoms.pickNumberInRange(MIN_MOVE_COUNT, MAX_MOVE_COUNT);
    }

    public Boolean getMoveOrStop() {
        this.moveOrStop = (this.moveCount >= MOVE_STANDARD_COUNT);
        return this.moveOrStop;
    }

    public Integer getCarPosition() {
        return this.carPosition;
    }

    public void moveCar() {
        if (this.getMoveOrStop().equals(MOVE)) {
            this.carPosition = this.carPosition + 1;
        }
        this.moveCount = 0;
    }
}
