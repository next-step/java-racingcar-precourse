package racingcar.view;

public class RacingCarOutputView {

    private static final String PRINT_RESULT = "실행결과";
    private static final String PRINT_WINNER = "최종 우승자: ";
    private static final String ERROR_CAR_NAME_MAX_LENGTH = "[ERROR] 자동차 이름은 최대 5자 까지 가능합니다.";
    private static final String ERROR_CAR_NAME_EMPTY = "[ERROR] 자동차 이름은 공백이 될 수 없습니다.";
    private static final String ERROR_NUMBER_FORMAT = "[ERROR] 횟수는 정수로 입력하세요.";

    public static void outputResult() {
        System.out.println(PRINT_RESULT);
    }

    public static void outputWinner(String sWinner) {
        System.out.println(PRINT_WINNER + sWinner);
    }

    public static void outputSeveralResult(String carName, String TrackNumber) {
        System.out.println(carName + " : " + TrackNumber);
    }

    public static void errorMaxLength() {
        System.out.println(ERROR_CAR_NAME_MAX_LENGTH);
    }

    public static void errorNameEmpty() {
        System.out.println(ERROR_CAR_NAME_EMPTY);
    }

    public static void errorNumberFormat() {
        System.out.println(ERROR_NUMBER_FORMAT);
    }
}
