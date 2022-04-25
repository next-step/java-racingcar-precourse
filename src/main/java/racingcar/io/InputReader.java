package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class InputReader {

    public static final String NAME_LENGTH_EXCEED_MESSAGE = "[ERROR] 자동차 이름은 5글자 이내이어야 한다.";
    private final String NUMBER_REGEX = "^[0-9]*$";
    public static final String COMMA = ",";

    public int readNumber() {
        String input = Console.readLine();
        validateNumber(input);
        return Integer.parseInt(input);
    }

    public String readStringWithCommas() {
        String input = Console.readLine();

        String[] carNames = input.split(COMMA);
        for (String carName : carNames) {
            validateCarNames(carName);
        }
        return input;
    }

    private void validateCarNames(String carName) {
        if (5 < carName.length()) {
            throw new IllegalArgumentException(NAME_LENGTH_EXCEED_MESSAGE);
        }
    }

    private void validateNumber(String input) {
        if (!input.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("입력이 잘못되었습니다. 숫자만 입력할 수 있습니다.");
        }
    }
}