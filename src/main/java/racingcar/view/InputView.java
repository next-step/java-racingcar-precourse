package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.generator.InputGenerator;

public class InputView {

    private static final String INPUT_CARS_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할회수";
    private static final String DELIMITER = ",";
    private static final String MUST_BE_NUMBER_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 한다.";

    public String[] inputCarsNames() {
        try {
            return inputCarsNames(Console::readLine);
        }catch (NumberFormatException ex) {
            throw new IllegalArgumentException(MUST_BE_NUMBER_ERROR_MESSAGE);
        }
    }

    public String[] inputCarsNames(InputGenerator inputGenerator) {
        System.out.println(INPUT_CARS_MESSAGE);
        String input = inputGenerator.input();
        return input.split(DELIMITER);
    }

    public int inputCarsMoveCount() {
        return inputCarsMoveCount(Console::readLine);
    }

    public int inputCarsMoveCount(InputGenerator inputGenerator) {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
        String input = inputGenerator.input();
        return Integer.parseInt(input);
    }

}
