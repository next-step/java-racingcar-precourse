package racingcar.domain.car.carname.validation;

import java.util.Arrays;
import java.util.List;

public class DefaultCarNameValidator implements CarNameValidator {

    List<CarNameValidator> validators;

    public DefaultCarNameValidator() {
        this.validators = Arrays.asList(new LengthValidator(), new DuplicateCarNameValidator());
    }

    @Override
    public void validate(String carName) throws IllegalArgumentException {
        for (CarNameValidator validator : validators) {
            validator.validate(carName);
        }
    }
}
