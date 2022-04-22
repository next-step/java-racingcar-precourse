package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.model.Racing;

import java.util.Arrays;

public class InputView {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_MOVE_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String CAR_NAME_DELIMITER = ",";

    public static String[] inputCarNames() {
        String[] input = readInput(INPUT_CAR_NAMES_MESSAGE).split(CAR_NAME_DELIMITER);
        try {
            Arrays.stream(input).forEach(Car::validateNameLength);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            input = inputCarNames();
        }
        return input;
    }

    public static String inputMoveCount() {
        String input = readInput(INPUT_MOVE_COUNT_MESSAGE);
        try {
            Racing.validNumber(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            input = inputMoveCount();
        }
        return input;
    }

    private static String readInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
