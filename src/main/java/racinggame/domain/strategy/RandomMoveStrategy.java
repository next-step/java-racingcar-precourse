package racinggame.domain.strategy;

import nextstep.utils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {

    @Override
    public boolean move() {
        int random = Randoms.pickNumberInRange(0, 9);
        return isMove(random);
    }

    private boolean isMove(final int random) {
        return random >= 4 && random < 10;
    }
}
