package racinggame;

import nextstep.utils.Randoms;

public class RandomMove implements MoveStrategy {

    private final int MIN_NUMBER = 0;
    private final int MAX_NUMBER = 9;

    @Override
    public int move() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
