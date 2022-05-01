package racingcar.view;

public class InputMessageView {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_RACING_ROUNDS_MASSAGE = "시도할 회수는 몇 회 인가요?";

    public static void printInputCarNamesMessage() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
    }

    public static void printInputRacingRoundsMessage() {
        System.out.println(INPUT_RACING_ROUNDS_MASSAGE);
    }
}
