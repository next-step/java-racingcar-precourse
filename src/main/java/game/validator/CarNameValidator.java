package game.validator;

public class CarNameValidator {

    private static final CarNameValidator instance = new CarNameValidator();

    private CarNameValidator() {
    }

    public static CarNameValidator getInstance() {
        return instance;
    }

    public void validate(String input) {
        validateNameLength(input);
        validateDuplication(input);
    }

    private void validateNameLength(String input) {

    }

    private void validateDuplication(String input) {

    }

}
