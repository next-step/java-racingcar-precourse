package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String GET_CARS_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String GET_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String BLANK_ERROR = "최소한 하나 이상의 이름을 입력해야합니다.";
    private static final String NEGATIVE_NUMBER_ERROR = "양수만 입력할 수 있습니다.";
    private static final String NOT_NUMBER_ERROR = "숫자를 입력해야 합니다.";
    private static final String ERROR_PREFIX = "[ERROR]";
    private static final String SPLIT_DELIMITER = ",";
    private static final int ZERO = 0;

    public List<String> getCarNames() {
        System.out.println(GET_CARS_NAME_MESSAGE);
        String input = Console.readLine();

        validateCarNamesInputValue(input);

        return Arrays.asList(input.split(SPLIT_DELIMITER));
    }

    private void validateCarNamesInputValue(String input) {
        try {
            validateEmpty(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
            getCarNames();
        }
    }

    private void validateEmpty(String input) {
        if (input == null || input.isEmpty() || input.equals(SPLIT_DELIMITER)) {
            throw new IllegalArgumentException(BLANK_ERROR);
        }
    }

    public int getTryCount() {
        System.out.println(GET_TRY_COUNT_MESSAGE);
        String input = Console.readLine();

        try {
            return parseIntFromInput(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
            return getTryCount();
        }
    }

    private int parseIntFromInput(String input) {
        int parsed = getParsed(input);
        if (parsed < ZERO) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR);
        }

        return parsed;
    }

    private int getParsed(String input) {
        int parsed;

        try {
            parsed = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR);
        }

        return parsed;
    }

}
