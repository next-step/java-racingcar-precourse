package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;

public class RacingGameInputView {
    private static final String ENTER_CAR_LIST = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ENTER_ROUND = "시도할 회수는 몇회인가요?";

    private RacingGameInputView() {
        throw new UnsupportedOperationException();
    }

    public static String inputCarList() {
        System.out.println(ENTER_CAR_LIST);

        return Console.readLine();
    }

    public static String inputRound() {
        System.out.println(ENTER_ROUND);

        return Console.readLine();
    }
}
