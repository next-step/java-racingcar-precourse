package com.freeefly.validator;

public class ProceedCountValidator {
    public Boolean isProceedCountValid(String input) {
        return isNumber(input);
    }

    private Boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
