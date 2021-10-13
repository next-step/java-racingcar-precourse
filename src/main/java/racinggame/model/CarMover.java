package racinggame.model;

import nextstep.utils.Randoms;
import racinggame.enums.RANDOM_MOVE_RESULT;
import racinggame.environments.GlobalVariables;
import racinggame.vo.Car;

public class CarMover {
    public static RANDOM_MOVE_RESULT moveRandomizly(Car car) {
        RANDOM_MOVE_RESULT genRandomMove =
                Randoms.pickNumberInRange(GlobalVariables.MIN_RAMDOM_VALUE, GlobalVariables.MAX_RANDOM_VALUE) <= GlobalVariables.MAX_STAY_VALUE ?
                        RANDOM_MOVE_RESULT.STAY : RANDOM_MOVE_RESULT.FORWARD;

        if (genRandomMove == RANDOM_MOVE_RESULT.FORWARD) {
            car.forward();
        }

        return genRandomMove;
    }
}
