package racingcar.view;

public class InputView {
    private static final String INPUT_RACING_CAR_NAMES = "경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT = "시도할 횟수";

    public static void printInputRacingCarNames() {
        System.out.println(INPUT_RACING_CAR_NAMES);
    }

    public static void printInputTryCount() {
        System.out.println(INPUT_TRY_COUNT);

    }

}
