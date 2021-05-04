package com.freeefly.validator;

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
            isNameLengthValid = isNameLengthValid(names[i]);
        }
        return isNameLengthValid;
    }

    private boolean isNameLengthValid(String name) {
        return name.length() > 0 && name.length() <= 5;
    }
}
