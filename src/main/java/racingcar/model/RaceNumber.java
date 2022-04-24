package racingcar.model;

import racingcar.constant.Digit;
import racingcar.constant.ErrorMessage;
import racingcar.constant.Format;

public class RaceNumber {

    private int raceNumber;

    public RaceNumber(String raceNumber) {
        isEmpty(raceNumber);
        isNumber(raceNumber);
        isGreaterThenZero(raceNumber);
        this.raceNumber = mapRaceNumber(raceNumber);
    }

    private int mapRaceNumber(String raceNumber) {
        return Integer.parseInt(raceNumber);
    }

    private void isEmpty(String raceNumber) {
        if (null == raceNumber || raceNumber.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_RACE_NUMBER.getMessage());
        }
    }

    private void isNumber(String raceNumber) {
        if (!raceNumber.matches(Format.NUMBER_FORMAT.getFormat())) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_RACE_NUMBER.getMessage());
        }
    }

    private void isGreaterThenZero(String raceNumber) {
        if (Integer.parseInt(raceNumber) < Digit.STANDARD_ZERO.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.IS_ZERO.getMessage());
        }
    }

    public int getRaceNumber() {
        return this.raceNumber;
    }

    public void minus() {
        this.raceNumber--;
    }

    public boolean isZero() {
        return this.raceNumber == Digit.ZERO.getNumber();
    }

}
