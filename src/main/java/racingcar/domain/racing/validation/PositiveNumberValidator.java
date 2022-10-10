package racingcar.domain.racing.validation;

public class PositiveNumberValidator implements RacingValidator {

    private static final int POSITIVE_NUMBER_THRESHOLD = 1;

    @Override
    public void validate(String tryNo) throws IllegalArgumentException {
        if (Integer.parseInt(tryNo) < POSITIVE_NUMBER_THRESHOLD) {
            throw new IllegalArgumentException(ERROR_POSITIVE_NUMBER_MESSAGE);
        }
    }
}
