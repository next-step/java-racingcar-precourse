package racingcar.util;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.apache.bval.jsr.ApacheValidationProvider;

public abstract class SelfValidating<T> {

    private final Validator validator;

    protected SelfValidating() {
        validator = Validation.byProvider(ApacheValidationProvider.class).configure().buildValidatorFactory()
                .getValidator();

    }

    protected void validateSelf() {
        Set<ConstraintViolation<T>> violations = validator.validate((T) this);
        if (!violations.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}