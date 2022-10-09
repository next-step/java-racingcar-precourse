package racingcar.view;

public class RacingCarOutputView {

    private static final String RACING_CAR_NAME_DIRECTION = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACING_TIME_DIRECTION = "시도할 회수는 몇회인가요?";
    private static final String RACING_RESULT_DIRECTION = "실행 결과";
    private static final String RACING_WINNER_DIRECTION = "최종 우승자 : %s%n";

    public static void printRacingCarNameDirection() {
        System.out.println(RACING_CAR_NAME_DIRECTION);
    }

    public static void printRacingTimeDirection() {
        System.out.println(RACING_TIME_DIRECTION);
    }

    public static void printRacingResultDirection() {
        System.out.println(RACING_RESULT_DIRECTION);
    }

    public static void printRacingResult(String racingResult) {
        System.out.println(racingResult);
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printRacingWinners(String winners) {
        System.out.printf(RACING_WINNER_DIRECTION, winners);
    }

    public static void printIllegalArgumentErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
