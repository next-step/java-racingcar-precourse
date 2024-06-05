package game.validator;

import static game.config.constant.Rule.*;

import game.exception.constant.ErrorMessage;
import java.util.Arrays;

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
        String[] names = input.split(NAME_DELIMITER);
        Arrays.stream(names)
            .filter(name -> name.length() > MAX_NAME_LENGTH)
            .findAny()
            .ifPresent(name -> {
                throw new IllegalArgumentException(ErrorMessage.EXCEED_NAME_LENGTH.getMessage());
            });
    }

    private void validateDuplication(String input) {
        String[] names = input.split(NAME_DELIMITER);
        long originalCount = names.length;
        long uniqueCount = Arrays.stream(names).distinct().count();

        if (originalCount != uniqueCount) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NAME_FOUND.getMessage());
        }
    }

}
