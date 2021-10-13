package racinggame.domain;

import racinggame.msg.ErrorMessage;

public class RaceNum {
    private final int raceNum;

    public RaceNum(String raceNum) {
        validateRaceNum(raceNum);
        this.raceNum = Integer.parseInt(raceNum);
    }

    public int getRaceNum() {
        return raceNum;
    }

    private void validateRaceNum(String originRaceNum) {
        isNotNull(originRaceNum);
        isValidLength(originRaceNum);
        isInteger(originRaceNum);
        isValidRaceNum(originRaceNum);
    }

    private void isValidRaceNum(String originRaceNum) {
        int raceNum = Integer.parseInt(originRaceNum);
        if (raceNum < 0) {
            throw new IllegalArgumentException(ErrorMessage.RACE_NUM_CAN_BE_POSITIVE);
        }
    }

    private void isInteger(String originRaceNum) {
        try {
            Integer.parseInt(originRaceNum);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ErrorMessage.RACE_NUM_CAN_BE_INTEGER);
        }
    }

    private void isValidLength(String originRaceNum) {
        if (originRaceNum.length() <= 0) {
            throw new IllegalArgumentException(ErrorMessage.RACE_NUM_LENGTH_CAN_BE_IN_VALID_RANGE);
        }
    }

    private void isNotNull(String originRaceNum) {
        if (originRaceNum == null) {
            throw new IllegalArgumentException(ErrorMessage.RACE_NUM_CAN_NOT_BE_NULL);
        }
    }
}
