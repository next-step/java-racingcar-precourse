package racingcar.car.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputCarNames {

    private static final String SHOW_CAR_NAMES_MESSAGE = "자동차 이름을 입력해주세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String DELIMITER = ",";

    public static String[] readCarNames() {
        System.out.println(SHOW_CAR_NAMES_MESSAGE);
        String input = Console.readLine();
        System.out.println();
        return input.split(DELIMITER);
    }
}
