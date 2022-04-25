package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.domain.NumberOfRound.MAX_TRY;

public class InputView {
    private static final String MSG_REQUEST_INPUT_CAR_NAME =
            "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MSG_REQUEST_INPUT_NUMBER_OF_ROUND =
            "시도할 횟수는 몇회인가요? (" + MAX_TRY + "회 이내로 입력하세요)";

    public static String requestInputCarName() {
        System.out.println(MSG_REQUEST_INPUT_CAR_NAME);
        return readLine().trim();
    }

    public static String requestInputNumberOfRound() {
        System.out.println(MSG_REQUEST_INPUT_NUMBER_OF_ROUND);
        return readLine().trim();
    }

}
