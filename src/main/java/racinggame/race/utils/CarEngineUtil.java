package racinggame.race.utils;

import nextstep.utils.Randoms;
import racinggame.Enum.Error;

public class CarEngineUtil {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int MIN_CAN_MOVE_NUMBER = 4;
    private static final int MAX_CAN_MOVE_NUMBER = 9;

    public static int getNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    public static boolean validationNumber(int rndNumber) {
        return rndNumber >= MIN_NUMBER && rndNumber <= MAX_NUMBER;
    }

    public static boolean canEngineRunConfirm(int rndNumber) {
        if(!CarEngineUtil.validationNumber(rndNumber)){
            throw new IllegalArgumentException(Error.WRONG_ERR_NUMBER.getMsg());
        }
        return rndNumber >= MIN_CAN_MOVE_NUMBER && rndNumber <= MAX_CAN_MOVE_NUMBER;
    }

}
