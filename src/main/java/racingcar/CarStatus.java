package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public enum CarStatus {
    GO,
    STOP;

    public static final int MIN_NUM = 0;
    public static final int MAX_NUM = 9;
    public static final int DESIDE_NUM = 4;

    public static CarStatus stopOrGo() {
        int randomNum = pickNumberInRange(MIN_NUM, MAX_NUM);

        return (randomNum >= DESIDE_NUM) ? GO : STOP;
    }
}

