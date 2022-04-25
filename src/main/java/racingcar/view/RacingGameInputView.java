package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingGameInputView {

    private static String INPUT_CAR_NAME = "경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)";
    private static String INPUT_CAR_TRACK_NUMBER = "시도할 횟수";

    public static String inputCarName() {
        System.out.println(INPUT_CAR_NAME);
        return readLine();
    }

    public static String inputCarTrackNumber() {
        System.out.println(INPUT_CAR_TRACK_NUMBER);
        return readLine();
    }

}
