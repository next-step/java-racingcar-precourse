package racingcar.movestategy;


import camp.nextstep.edu.missionutils.Randoms;

public class RandomMove implements MoveStrategy {

    private final int MIN_NUMBER = 0;
    private final int MIN_MOVE_NUMBER = 4;
    private final int MAX_NUMBER = 9;

    @Override
    public boolean move() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER) >= MIN_MOVE_NUMBER;
    }
}
