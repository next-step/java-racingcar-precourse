package racingcar.view;

public class Input {
    private static final String CARNAME_INPUT_REQUIRED_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_INPUT_REQUIRED_MESSAGE = "시도할 횟수는 몇회인가요?";

    public void requireCarNames() {
        System.out.println(CARNAME_INPUT_REQUIRED_MESSAGE);
    }

    public void requireRound() {
        System.out.println(ROUND_INPUT_REQUIRED_MESSAGE);
    }
}
