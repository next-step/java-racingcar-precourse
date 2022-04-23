package racingcar.utils;

import racingcar.model.error.ErrorMessage;

import java.util.*;

public class NameParse {

    public static String[] parseName(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VALUE);
        }
        if (hasDuplicateName(input)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NAME);
        }

        return input.split(",");
    }

    private static boolean hasDuplicateName(String input) {
        String[] splitNameResult = input.split(",");
        Set<String> duplicateCheckSet =  new HashSet<>();
        for (String name : splitNameResult) {
            duplicateCheckSet.add(name);
        }

        return splitNameResult.length != duplicateCheckSet.size();
    }

    private static boolean isBlank(String input) {
        return Objects.isNull(input) || input.trim().isEmpty();
    }
}
