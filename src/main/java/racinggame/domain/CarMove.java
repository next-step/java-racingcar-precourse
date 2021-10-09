package racinggame.domain;

/**
 * Name : CarMove <br/>
 * Description : 자동차 이동 클래스
 */
public class CarMove {

    public static final int MOVE_MIN_NUMBER = 4;
    public static final int MOVE_MAX_NUMBER = 9;

    public static MoveStatus getMoveStatus(int randomNumber) {
        if (isMovable(randomNumber)) {
            return MoveStatus.MOVE;
        }
        return MoveStatus.STOP;
    }

    private static boolean isMovable(int randomNumber) {
        return randomNumber >= MOVE_MIN_NUMBER && randomNumber <= MOVE_MAX_NUMBER;
    }
}
