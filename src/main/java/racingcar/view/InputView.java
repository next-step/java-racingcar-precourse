package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String CAR_COUNT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    private static final String TRY_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public static String inputCarCount() {
        System.out.println(CAR_COUNT_MESSAGE);
        return Console.readLine();
    }

    public static String inputTryCount() {
        System.out.println(TRY_COUNT_MESSAGE);
        return Console.readLine();
    }
}
