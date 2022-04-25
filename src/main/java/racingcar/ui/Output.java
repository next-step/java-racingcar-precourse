package racingcar.ui;

import racingcar.dto.Result;

public class Output {
    private static final String RECEIVE_CAR_NAMES_MSG = "경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)\n";
    private static final String RECEIVE_COUNT_MSG = "시도할 횟수\n";
    public static final String ERROR_PREFIX = "[ERROR]";
    public static final String FINAL_WINNER_PREFIX = "최종 우승자: ";
    public static final String CURRENT_RESULT_PREFIX = "실행결과\n";

    public static void printReceiveCarNames() {
        System.out.print(RECEIVE_CAR_NAMES_MSG);
    }

    public static void printReceiveCount() {
        System.out.print(RECEIVE_COUNT_MSG);
    }

    public static void printError(Exception e) {
        System.out.print(ERROR_PREFIX + e.getMessage() + "\n");
    }

    public static void printCurrentResult(Result result) {
        StringBuilder sb = new StringBuilder();
        for (Result.CarDTO carDTO : result.getCarDTOList()) {
            sb.append(carDTO.getName());
            sb.append(" : ");
            repeatHyphen(sb, carDTO.getPosition());
            sb.append("\n");
            System.out.println(sb);
        }
    }

    private static void repeatHyphen(StringBuilder sb, int position) {
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
    }

    public static void printLastResult(String joinedString) {
        System.out.println(FINAL_WINNER_PREFIX + joinedString);
    }

    public static void printCurrentResultPrefix() {
        System.out.println(CURRENT_RESULT_PREFIX);
    }
}
