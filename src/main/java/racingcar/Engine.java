package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Engine {
    private static final int WORKING_NUMBER = 4;

    public boolean isWorking() {
        return WORKING_NUMBER <= Randoms.pickNumberInRange(0, 9);
    }
}
