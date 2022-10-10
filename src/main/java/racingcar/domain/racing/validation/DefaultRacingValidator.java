package racingcar.domain.racing.validation;

import java.util.Arrays;
import java.util.List;

public class DefaultRacingValidator implements RacingValidator {

    List<RacingValidator> validators;

    public DefaultRacingValidator() {
        this.validators = Arrays.asList(new NumberValidator(), new PositiveNumberValidator());
    }

    @Override
    public void validate(String tryNo) throws IllegalArgumentException {
        for (RacingValidator validator : validators) {
            validator.validate(tryNo);
        }
    }
}
