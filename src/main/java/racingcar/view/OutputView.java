package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.utils.Validation;

public class OutputView {
    private static final String ERROR = "[ERROR]";
    private static final String INPUT_ERROR = "자동차 이름은 5글자 이하로 입력하여 주시기 바랍니다.";
    private static final String COUNT_INPUT_ERROR = "숫자로만 입력하여 주시기 바랍니다.";
    private static final String RESULT = "실행 결과";
    private static final String WINNER = "최종 우승자: ";

    public static String printInputError() {
        System.out.println(ERROR + INPUT_ERROR);
        return ERROR + INPUT_ERROR;
    }

    public static String printInputCountError() {
        System.out.println(ERROR + COUNT_INPUT_ERROR);
        return ERROR + COUNT_INPUT_ERROR;
    }

    public static void printResult() {
        System.out.println(RESULT);
    }

    public static void printCarPosition(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName());
        sb.append(" : ");
        int count = 0;
        while (count < car.getScore()) {
            sb.append("-");
            count++;
        }
        System.out.println(sb.toString());
    }

    public static void printNewLine() {
        System.out.println("\n");
    }

    public static void printWinner(String winner) {
        System.out.println(WINNER + winner);
    }
}

