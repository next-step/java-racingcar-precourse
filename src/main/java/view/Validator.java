package view;

import java.util.Arrays;

public class Validator {

    public static final String NAME_ERROR_MESSAGE = "자동차 이름은 5자 이하만 가능합니다. 다시 입력해 주세요.";
    public static final String COUNT_ERROR_MESSAGE = "횟수는 숫자만 가능합니다. 다시 입력해 주세요.";

    public void validateCarName(String input) {
        if (Arrays.stream(input.split(",")).anyMatch(name -> name.length() > 5)) {
            throw new IllegalArgumentException(NAME_ERROR_MESSAGE);
        }
    }

    public int validateInputRacingCount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(COUNT_ERROR_MESSAGE);
        }
    }
}
