package racingcar.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RaceRoundInputValidator implements ConstraintValidator<RaceRoundInputCheck, String> {
    private static final int MIN_COUNT = 1;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isValid;

        try {
            int count = Integer.parseInt(value);
            isValid = count >= MIN_COUNT;

        } catch (NumberFormatException e) {
            isValid = false;
        }

        return isValid;
    }
}
