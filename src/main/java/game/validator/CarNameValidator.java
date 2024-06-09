package game.validator;

import static game.config.constant.Rule.*;

import game.exception.constant.ErrorMessage;
import java.util.Arrays;

public class CarNameValidator {

    private CarNameValidator() {
    }

    public static void validate(String input) {
        validateNameLength(input);
        validateDuplication(input);
    }

    public static void validateNameLength(String input) {
        String[] names = input.split(NAME_DELIMITER);
        Arrays.stream(names)
            .filter(name -> name.length() > MAX_NAME_LENGTH)
            .findAny()
            .ifPresent(name -> {
                throw new IllegalArgumentException(ErrorMessage.EXCEED_NAME_LENGTH.getMessage());
            });
    }

    private static void validateDuplication(String input) {
        String[] names = input.split(NAME_DELIMITER);
        long originalCount = names.length;
        long uniqueCount = Arrays.stream(names).distinct().count();

        if (originalCount != uniqueCount) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NAME_FOUND.getMessage());
        }
    }

}
