package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Driving {

    private static int START_RANGE = 0;
    private static int END_RANGE = 9;
    private static int ADVANCE_NUMBER = 4;

    private Driving() {
    }

    public static DriveStatus isDrive() {
        if (Randoms.pickNumberInRange(START_RANGE, END_RANGE) >= ADVANCE_NUMBER) {
            return DriveStatus.DRIVE;
        }
        return DriveStatus.STOP;
    }
}
