package view;

public class GameOutput {

    private static final String INSERT_CAR_NAME = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_COUNT = "시도할 횟수는 몇 회인가요?";
    private static final String GAME_RESULT_COMMENT = "실행 결과";
    private static final String ENTER_AGAIN = " 다시 입력해 주세요.";

    public static void printInsertCarName() {
        System.out.println(INSERT_CAR_NAME);
    }

    public static void printEnterAgain(Exception e) {
        System.out.println(e.getMessage() + ENTER_AGAIN);
    }

    public static void printAttemptCount() {
        System.out.println(ATTEMPT_COUNT);
    }

}
