package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String CAR_NAME_REQUEST = "경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)";
    private static final String COUNT_REQUEST = "시도할 횟수";

    public static String printCarNameRequest() {
        System.out.println(CAR_NAME_REQUEST);
        return readLine();
    }

    public static String printCountRequest() {
        System.out.println(COUNT_REQUEST);
        return readLine();
    }
}
