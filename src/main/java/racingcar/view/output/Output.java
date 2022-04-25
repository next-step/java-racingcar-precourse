package racingcar.view.output;

import java.util.List;

public class Output {
    private static final String ENTER_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분)";
    private static final String ENTER_TRY_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RACING_RESULT_MESSAGE = "실행결과";
    private static final String WINNER_MESSAGE = "최종 우승자: ";
    private static final String CAR_NAME_RESULT_DELIMITER = " : ";
    private static final String RACING_RESULT_DELIMITER = "\n";
    private static final String DISTANCE_MARK = "-";
    private static final String WINNING_CAR_DELIMITER = ", ";
    private static final String ERROR_PREFIX = "[ERROR]";

    public void enterCarName() {
        System.out.println(ENTER_CAR_NAME_MESSAGE);
    }

    public void enterTryNumber() {
        System.out.println(ENTER_TRY_NUMBER_MESSAGE);
    }

    public void runResultMessage() {
        System.out.println(RACING_RESULT_MESSAGE);
    }

    public void racingResult(String carName, int distance) {
        StringBuffer sb = new StringBuffer();
        sb.append(carName).append(CAR_NAME_RESULT_DELIMITER);

        for (int index = 0; index < distance; index++) {
            sb.append(DISTANCE_MARK);
        }
        System.out.println(sb.toString());
    }

    public void racingResultDelimiter() {
        System.out.print(RACING_RESULT_DELIMITER);
    }

    public void winningCars(List<String> winningCarNames) {
        System.out.print(WINNER_MESSAGE + String.join(WINNING_CAR_DELIMITER, winningCarNames));
    }

    public void printError(Exception e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
    }
}
