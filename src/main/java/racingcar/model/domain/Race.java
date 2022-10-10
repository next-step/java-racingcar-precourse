package racingcar.model.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Race {

    private static final int GO_FORWARD_BASE = 4;
    public static final int GO_FORWARD_SIZE = 1;
    public static final int STOP = 0;
    private static final int BEGIN_NUMBER = 0; //임의생성 숫자 범위 최소값
    private static final int END_NUMBER = 9; //임의생성 숫자 범위 최대값

    public static int createRandomNumber() {
        return Randoms.pickNumberInRange(BEGIN_NUMBER, END_NUMBER);
    }

    public static int goForward(int number) {
        if (number >= GO_FORWARD_BASE) {
            return GO_FORWARD_SIZE;
        }
        return STOP;
    }
}
