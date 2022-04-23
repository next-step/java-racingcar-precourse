package racingcar.domain;

import racingcar.constants.MessageConstants;

public class AttemptsNumber {
    private final int attemptsNumber;

    public AttemptsNumber(String inputValue) {
        validateAttemptsNumber(inputValue);
        attemptsNumber = Integer.parseInt(inputValue);
    }

    private void validateAttemptsNumber(String inputValue) {
        validateNullOrEmpty(inputValue);
        validateNumeric(inputValue);
        validatePositive(inputValue);
    }

    private void validateNullOrEmpty(String inputValue) {
        if (inputValue == null || inputValue.trim().isEmpty()) {
            throw new IllegalArgumentException(MessageConstants.ERROR_MESSAGE_ATTEMPTS_NUMBER_INPUT_EMPTY);
        }
    }

    private void validateNumeric(String inputValue) {
        try {
            Integer.parseInt(inputValue.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MessageConstants.ERROR_MESSAGE_ATTEMPTS_NUMBER_NOT_NUMERIC);
        }
    }

    private void validatePositive(String inputValue) {
        if (Integer.parseInt(inputValue) < 1) {
            throw new IllegalArgumentException(MessageConstants.ERROR_MESSAGE_ATTEMPTS_NUMBER_NOT_POSITIVE);
        }
    }

    public int getAttemptsNumber() {
        return attemptsNumber;
    }
}
