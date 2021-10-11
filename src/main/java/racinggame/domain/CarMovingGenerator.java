package racinggame.domain;

import nextstep.utils.Randoms;

public class CarMovingGenerator {
    public static CarMove randomCarMove() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            return CarMove.MOVE;
        }
        return CarMove.STOP;
    }
}
