package racingcar.domain;

import racingcar.message.ErrorMessage;
import racingcar.util.ValidationUtils;

public class NumberOfRace {

    private final String numberOfRace;

    public NumberOfRace(String numberOfRace) {
        validNumber(numberOfRace);
        this.numberOfRace = numberOfRace;
    }

    public int getNumberOfRace() {
        return Integer.parseInt(numberOfRace);
    }

    private void validNumber(String numbers) {
        for (int i = 0; i < numbers.length(); i++) {
            isNumber(numbers.charAt(i));
        }
        if (ValidationUtils.isLessThanMinimum(Integer.parseInt(numbers), 1)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OF_RACE_THEN_ZERO.getMessage());
        }
    }

    private void isNumber(char number) {
        if (!ValidationUtils.isNumber(number)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OF_RACE_NOT_NUMBER.getMessage());
        }
    }
}
