package racingcar.view;

public class Input {
    private static final String ASK_CAR_STRING = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_TRY_ROUND_STRING = "시도할 회수는 몇 회인가요?";

    public static void askCarNames() {
        System.out.println(ASK_CAR_STRING);
    }

    public static void askTryRound() {
        System.out.println(ASK_TRY_ROUND_STRING);
    }
}
