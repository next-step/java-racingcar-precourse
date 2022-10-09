package racingcar.model;

import racingcar.constant.GameEnvironment;
import racingcar.exception.InvalidRaceCountFormatException;
import racingcar.exception.InvalidRaceCountRangeException;
import racingcar.view.UserInput;

public class RaceCount {

    private final int value;

    public RaceCount(UserInput userInput) {
        this.value = mapToNumber(userInput.getValue());
    }

    public int getValue() {
        return this.value;
    }

    private int mapToNumber(String userInput) {
        verifyNumber(userInput);
        verifyRange(userInput);
        return Integer.parseInt(userInput);
    }

    private void verifyRange(String source) {
        if (Integer.parseInt(source) < GameEnvironment.MIN_RACE_COUNT) {
            throw new InvalidRaceCountRangeException();
        }
    }

    private void verifyNumber(String source) {
        String pattern = "^[+|-]?[0-9]+$";
        if (!source.matches(pattern)) {
            throw new InvalidRaceCountFormatException();
        }
    }
}
