package controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import utils.Constants;
import utils.ErrorConstants;

public class InputValidator {

    private static final String COMMA_SEPARATED_REGEX = "^(?:[가-힣a-zA-Z0-9]+,)*[가-힣a-zA-Z0-9]+$" ;

    private static void inputIsBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorConstants.BLANK);
        }
    }

    private static int isInteger(String input) {
        inputIsBlank(input);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorConstants.OVER_INTEGER);
        }
    }

    private static void isNumberInRange(int number) {
        if (number < Constants.MIN_COUNT || number > Constants.MAX_COUNT) {
            throw new IllegalArgumentException(ErrorConstants.OVER_RANGE);
        }
    }

    private static void isCommaSeparated(String input) {
        if (!input.matches(COMMA_SEPARATED_REGEX)) {
            throw new IllegalArgumentException(ErrorConstants.INADEQUATE_INPUT);
        }
    }

    private static List<String> validateCommaSeparatedStrings(String input) {
        isCommaSeparated(input);
        List<String> result = Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        return result;
    }

    private static void isOverWords(List<String> inputList) {
        List<String> longStrings = inputList.stream()
                .filter(str -> str.length() > Constants.MAX_WORD)
                .collect(Collectors.toList());

        if (!longStrings.isEmpty()) {
            throw new IllegalArgumentException(ErrorConstants.OVER_FIVE_WORDS);
        }
    }

    private static void isDuplicate(List<String> inputList) {
        Set<String> uniqueStrings = new HashSet<>(inputList);
        if (uniqueStrings.size() != inputList.size()) {
            throw new IllegalArgumentException(ErrorConstants.DUPLICATE_NAME);
        }
    }

    public static List<String> validateCarName(String input) {
        List<String> cars = validateCommaSeparatedStrings(input);
        isOverWords(cars);
        isDuplicate(cars);
        return cars;
    }

    public static int validateRaceCount(String input) {
        int count = isInteger(input);
        isNumberInRange(count);
        return count;
    }
}
