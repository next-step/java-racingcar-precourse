package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ENTER_TRY_COUNT = "시도할 횟수는 몇회인가요?";

    private InputView() {
    }

    public static String readCarNames() {
        System.out.println(ENTER_CAR_NAMES);
        return Console.readLine();
    }

    public static int readTryCount() {
        System.out.println(ENTER_TRY_COUNT);
        return Integer.parseInt(Console.readLine());
    }
}
