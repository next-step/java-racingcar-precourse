package racingcar.domain.car.carname.validation;

public class FirstCommaValidator implements CarNamesValidator {

    private static final String START_WITH_COMMA = ",";

    @Override
    public void validate(String carNames) throws IllegalArgumentException {
        if (carNames.startsWith(START_WITH_COMMA)) {
            throw new IllegalArgumentException(ERROR_FIRST_COMMA_MESSAGE);
        }
    }
}
