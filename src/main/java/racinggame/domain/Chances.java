package racinggame.domain;

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
            System.out.println(Constant.INPUT_CHANCES_ERROR_MSG);
            return false;

        }
        checkValid(validation.checkChancesRange(Integer.parseInt(chances)), Constant.INPUT_CHANCES_RANGE_ERROR_MSG);
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
