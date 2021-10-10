package racinggame.domain;

import nextstep.utils.Randoms;

import static racinggame.constants.RaceGameConstants.MOVING_FORWARD;

public enum RaceOperate {
    STOP(""), MOVE("-");

    private final String regex;

    RaceOperate(String regex) {
        this.regex = regex;
    }

    public static RaceOperate run(int min, int max) {
        return Randoms.pickNumberInRange(min, max) >= MOVING_FORWARD ? MOVE : STOP ;
    }

    public String getRegex() {
        return regex;
    }

}
