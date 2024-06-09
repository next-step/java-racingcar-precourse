package view;

import java.util.Arrays;

public class Validator {

    public static final String NAME_ERROR_MESSAGE = "자동차 이름은 5자 이하만 가능합니다. 다시 입력해 주세요.";

    public void validateCarName(String input) {
        if (Arrays.stream(input.split(",")).anyMatch(name -> name.length() > 5)) {
            throw new IllegalArgumentException(NAME_ERROR_MESSAGE);
        }
    }
}
