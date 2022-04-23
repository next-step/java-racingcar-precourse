package racingcar.input.validator.impl;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.ExceptionType;
import racingcar.input.validator.InputValidator;
import racingcar.utils.WordUtils;

public class CarNamesLengthValidator implements InputValidator {
    private static final int MAX_NAME_LENGTH = 5;

    @Override
    public void validate(String input) {
        List<String> carNames = Arrays.asList(input.split(WordUtils.COMMA));
        carNames.replaceAll(String::trim);
        for (String name : carNames) {
            validateNameLength(name);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ExceptionType.IS_NAME_LENGTH_OVER_FIVE.getMessage());
        }
    }
}
