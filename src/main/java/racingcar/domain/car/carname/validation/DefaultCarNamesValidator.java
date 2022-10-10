package racingcar.domain.car.carname.validation;

import java.util.Arrays;
import java.util.List;

public class DefaultCarNamesValidator implements CarNamesValidator {

    List<CarNamesValidator> validators;

    public DefaultCarNamesValidator() {
        this.validators = Arrays.asList(new EmptyValidator(), new FirstCommaValidator());
    }

    @Override
    public void validate(String carNames) throws IllegalArgumentException {
        for (CarNamesValidator validator : validators) {
            validator.validate(carNames);
        }
    }
}
