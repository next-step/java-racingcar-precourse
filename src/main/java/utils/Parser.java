package utils;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String INVALID_INPUT_ERROR = "[ERROR]: 이름을 확인할 수 없습니다. 다시 입력해주세요.";
    private static final String INVALID_COUNT_ERROR = "[ERROR]: 유효한 숫자를 입력해주세요.";
    public static List<String> validateCarNameInput(String input){
        try {
            validateNameContainsBlank(input);

            return Arrays.stream(input.split(", "))
                    .map(String::trim)
                    .toList();
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private static void validateNameContainsBlank(String input){
        if (input == null ||
            input.trim().isEmpty() ||
            Arrays.stream(input.split(",")).anyMatch(String::isBlank)) {

            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }

    public static int validateGameCountInput(String input) {
        try {
            validateGameCountIsPositive(input);
            int count = Integer.parseInt(input.trim());
            validateGameCountIsPositive(count);

            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_COUNT_ERROR);
        }
    }

    private static void validateGameCountIsPositive(String input){
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_COUNT_ERROR);
        }
    }
    private static void validateGameCountIsPositive(int count){
        if (count <= 0) {
            throw new IllegalArgumentException(INVALID_COUNT_ERROR);
        }
    }

}
