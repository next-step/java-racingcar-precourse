package racingcar.domain;

import racingcar.constants.MessageConstants;

public class CarNamesInput {
    private final String names;

    public CarNamesInput(String inputValue) {
        validateNullOrEmpty(inputValue);
        this.names = inputValue;
    }

    private void validateNullOrEmpty(String inputValue) {
        if (inputValue == null || inputValue.trim().isEmpty()) {
            throw new IllegalArgumentException(MessageConstants.ERROR_MESSAGE_CAR_NAMES_INPUT_EMPTY);
        }
    }

    public String getNames() {
        return names;
    }
}
