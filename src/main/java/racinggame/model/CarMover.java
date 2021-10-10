package racinggame.model;

import nextstep.utils.Randoms;
import racinggame.enums.RANDOM_MOVE_RESULT;

public class CarMover {
    public RANDOM_MOVE_RESULT moveRandomizly(Car car) {
        RANDOM_MOVE_RESULT genRandomMove =
                Randoms.pickNumberInRange(0, 9) <= 3 ?
                        RANDOM_MOVE_RESULT.STAY : RANDOM_MOVE_RESULT.FORWARD;

        if (genRandomMove == RANDOM_MOVE_RESULT.FORWARD) {
            car.forward();
        }

        return genRandomMove;
    }
}
