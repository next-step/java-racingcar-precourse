package racingcar.domain.input;

import static racingcar.type.ErrorMessageType.INPUT_NOT_ALLOW_BLANK;

import racingcar.exception.InputWrongValueException;

public interface Input<T> {

    T create();

    default void validateBlank(String input) {
        validateWhitespace(input);
        validateNullOrEmpty(input);
    }

    static void validateWhitespace(String input) {
        for (char charAt : input.toCharArray()) {
            isWhitespace(charAt);
        }
    }

    static void isWhitespace(char charAt) {
        if (Character.isWhitespace(charAt)) {
            throw new InputWrongValueException(INPUT_NOT_ALLOW_BLANK.getMessage());
        }
    }

    static void validateNullOrEmpty(String input) {
        if (input == null || input.length() == 0) {
            throw new InputWrongValueException(INPUT_NOT_ALLOW_BLANK.getMessage());
        }
    }

}
