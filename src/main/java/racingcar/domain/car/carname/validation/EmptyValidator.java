package racingcar.domain.car.carname.validation;

public class EmptyValidator implements CarNamesValidator {

    private static final String CAR_NAMES_EMPTY = "";

    @Override
    public void validate(String carNames) throws IllegalArgumentException {
        if (CAR_NAMES_EMPTY.equals(carNames)) {
            throw new IllegalArgumentException(CarNamesValidator.ERROR_EMPTY_MESSAGE);
        }
    }
}
