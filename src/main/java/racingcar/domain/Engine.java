package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Engine {

    public static final int MIN_OF_RANGE = 0;
    public static final int MAX_OF_RANGE = 9;
    private static final int MIN_NEED_ENERGY = 4;

    public static ControlType getControlType() {
        if (isEnoughEnergy(generateRandomNumber())) {
            return ControlType.FORWARD;
        }
        return ControlType.STOP;
    }

    private static boolean isEnoughEnergy(int number) {
        return number >= MIN_NEED_ENERGY;
    }

    private static int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_OF_RANGE, MAX_OF_RANGE);
    }
}
