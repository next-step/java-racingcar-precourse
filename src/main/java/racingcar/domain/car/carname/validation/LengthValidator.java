package racingcar.domain.car.carname.validation;

public class LengthValidator implements CarNameValidator {

    @Override
    public void validate(String carName) throws IllegalArgumentException {
        if (carName.length() > CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_LENGTH_MESSAGE);
        }
    }
}
