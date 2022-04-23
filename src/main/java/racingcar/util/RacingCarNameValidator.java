package racingcar.util;

import java.util.HashSet;
import java.util.Set;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

public class RacingCarNameValidator implements ConstraintValidator<RacingCarNameCheck, String> {
    private static final int MAX_NAME_LENGTH = 5;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value.isEmpty() || value.startsWith(",") || value.endsWith(",")) {
            return false;
        }

        return checkInput(value);
    }

    private boolean checkInput(String input) {
        Set<String> nameSet = new HashSet<>();

        String[] names = input.split(",");
        boolean isValidName;
        int index = 0;

        do {
            isValidName = checkName(names[index]) && nameSet.add(names[index]);
            index++;
        } while (isValidName && index < names.length);

        return isValidName;
    }

    private boolean checkName(String name) {
        return StringUtils.isNotBlank(name) && name.length() <= MAX_NAME_LENGTH;
    }


}
