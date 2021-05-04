package com.freeefly.validator;

import static com.freeefly.config.RacingConfig.CAR_NAME_LENGTH_LIMIT;

public class CarNameValidator {
    public Boolean isNameValid(String carNames) {
        String[] names = carNames.split(",");
        if (names.length == 1 && names[0].length() == 0) {
            return false;
        }

        return isNameLengthValid(names);
    }

    private Boolean isNameLengthValid(String[] names) {
        Boolean isNameLengthValid = true;
        for (int i = 0; i < names.length; i++) {
            isNameLengthValid &= names[i].length() > 0 && names[i].length() <= CAR_NAME_LENGTH_LIMIT;
        }
        return isNameLengthValid;
    }

}
