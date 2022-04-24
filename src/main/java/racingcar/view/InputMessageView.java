package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputMessageView {
    private static final String INPUT_RACING_CAR_NAME = "경주 할 자동차 이름(이름은쉼표(,)기준으로구분)";
    private static final String INPUT_TRY_COUNT = "시도 할 회수";

    public static String inputRacingCarName() {
        System.out.println(INPUT_RACING_CAR_NAME);
        return Console.readLine();
    }

    public static String inputTryCount() {
        System.out.println(INPUT_TRY_COUNT);
        return Console.readLine();
    }

}
