package racingcar.input.validator.impl;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.ExceptionType;
import racingcar.input.validator.InputValidator;
import racingcar.utils.WordUtils;

public class CarQtyValidator implements InputValidator {
    private static final int MIN_CAR_QTY = 2;

    @Override
    public void validate(String input) {
        List<String> carsNames = Arrays.asList(input.split(WordUtils.COMMA));
        if (MIN_CAR_QTY > carsNames.size()) {
            throw new IllegalArgumentException(ExceptionType.IS_CAR_QTY_UNDER_TWO.getMessage());
        }
    }
}
