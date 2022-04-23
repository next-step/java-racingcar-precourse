package racingcar.service;


import racingcar.constant.MoveRange;
import racingcar.constant.MoveStatus;

public class CarMoveService {

    public MoveStatus getMoveStatus(int randomNumber) {
        if (randomNumber >= MoveRange.STOP_MIN && randomNumber <= MoveRange.STOP_MAX) {
            return MoveStatus.STOP;
        }
        if (randomNumber >= MoveRange.FORWARD_MIN && randomNumber <= MoveRange.FORWARD_MAX) {
            return MoveStatus.FORWARD;
        }
        return null;
    }
}
