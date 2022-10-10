package racingcar.domain.racing.validation;

public class NumberValidator implements RacingValidator {

    private static final String REGEX = "^[0-9]+$";

    @Override
    public void validate(String tryNo) throws IllegalArgumentException {
        if (!tryNo.matches(REGEX)) {
            throw new IllegalArgumentException(ERROR_NUMBER_MESSAGE);
        }
    }
}
