package racingcar.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InputHandler {

    private static final int MAX_NAME_SIZE = 5;
    private static final String NAME_SEPARATOR = ",";
    private static final String ERROR_PREFIX = "[ERROR] ";

    public int toInt(String userInput) {
        validateNotNumber(userInput);
        return Integer.parseInt(userInput);
    }

    public List<String> toCarNames(String userInput) {
        return validateCarNames(userInput);
    }

    private List<String> validateCarNames(String userInput) {
        validateEmpty(userInput);
        validateEmptyNames(userInput);
        validateExceededCounts(userInput);
        validateLeastName(userInput);
        return validateSameNames(userInput);
    }

    private void validateEmptyNames(String userInput) {
        String[] names = userInput.split(NAME_SEPARATOR);
        for (int i = 0; i < names.length; i++) {
            validateEmptyName(names[i].trim());
        }
    }

    private void validateLeastName(String userInput) {
        if (userInput.split(NAME_SEPARATOR).length < 2) {
            throw new IllegalArgumentException(ERROR_PREFIX + "자동차명은 2개 이상 입력되어야 합니다.");
        }
    }

    private void validateExceededCounts(String userInput) {
        String[] validate = userInput.split(NAME_SEPARATOR);
        for (int i = 0; i < validate.length; i++) {
            validateExceededCount(validate[i].trim());
        }
    }

    private void validateExceededCount(String name) {
        if (name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException(ERROR_PREFIX + "자동차명은 최대 5글자까지만 입력할 수 있습니다.");
        }
    }

    private void validateEmptyName(String name) {
        if (name.length() <= 0) {
            throw new IllegalArgumentException(ERROR_PREFIX + "자동차명은 반드시 2개 이상 입력되어야 합니다.");
        }
    }

    private void validateEmpty(String names) {
        if (names == null || names.length() == 0) {
            throw new IllegalArgumentException(ERROR_PREFIX + "사용자 입력값이 존재하지 않습니다.");
        }
    }

    private List<String> validateSameNames(String names) {
        String[] validate = names.split(NAME_SEPARATOR);
        List<String> arrayList = Arrays.asList(validate);
        for (int i = 0; i < validate.length; i++) {
            validateSameName(validate[i], arrayList);
        }
        return arrayList;
    }

    private void validateSameName(String name, List<String> arrayList) {
        if (isSameName(name, arrayList)) {
            throw new IllegalArgumentException(ERROR_PREFIX + "중복된 자동차명이 존재합니다.");
        }
    }

    private boolean isSameName(String name, List<String> arrayList) {
        return Collections.frequency(arrayList, name) > 1;
    }

    private void validateNotNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            validateNotPlus(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_PREFIX + "시도 횟수는 반드시 숫자로 입력해야 합니다.");
        }
    }

    private void validateNotPlus(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ERROR_PREFIX + "시도 횟수는 양수여야 합니다.");
        }
    }
}
