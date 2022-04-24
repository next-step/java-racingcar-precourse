package racingcar.model;

import racingcar.model.util.NumberGenerator;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car implements NumberGenerator {
    private static final int INIT_MOVE_CNT = 0;
    private static final int MOVEABLE_MIN_NUMBER = 4;

    private Name carName;
    private int moveCnt;

    public Car(String name) {
        this.carName = new Name(name);
        this.moveCnt = INIT_MOVE_CNT;
    }

    public void move() {
        if (isMovealble(generateNumber())) {
            addMoveCnt();
        }
    }

    public String getCarName() {
        return this.carName.getName();
    }

    public void addMoveCnt() {
        moveCnt++;
    }

    public int getMoveCnt() {
        return moveCnt;
    }

    public boolean isMovealble(int generatedNumber) {
        if (generatedNumber >= MOVEABLE_MIN_NUMBER) {
            return true;
        }
        return false;
    }

    @Override
    public int generateNumber() {
        return pickNumberInRange(MIN, MAX);
    }
}
