package racinggame.utils;

import racinggame.domain.Validation;

public class Chances {
    public int chances;
    public Boolean isValidValue;
    public static Validation validation;

    public Chances(String chances) {
        this.isValidValue = true;
        this.validation = new Validation();
        if (isValidChance(chances)) {
            this.chances = Integer.parseInt(chances);
        }
    }

    public Boolean isValidChance(String chances) {
        try {
            Integer.parseInt(chances);
        } catch (Exception e) {
            this.isValidValue = false;
            System.out.println(Message.INPUT_CHANCES_ERROR_MSG);
            return false;

        }
        checkValid(validation.checkChancesRange(Integer.parseInt(chances)),Message.INPUT_CHANCES_RANGE_ERROR_MSG);
        return true;
    }

    public void checkValid(Boolean valid, String message) {
        if (!valid) {
            this.isValidValue = false;
            makeException(message);
        }
    }

    public static void makeException(String message) {
        try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println(message);
        }
    }
}
