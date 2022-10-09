package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;

public class Scanner {

    private static final String CAR_NAMES_MESSAGE = "경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_MESSAGE = "시도할 회수";

    private Scanner() {
    }

    public static String carNames() {
        System.out.println(CAR_NAMES_MESSAGE);
        String names = Console.readLine();
        return names;
    }

    public static String gameRound() {
        System.out.println(ROUND_MESSAGE);
        String input = Console.readLine();
        return input;
    }

}
