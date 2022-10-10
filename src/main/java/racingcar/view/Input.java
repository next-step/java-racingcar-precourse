package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 입력 요청 객체
 *
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.09
 */
public class Input {

    public static String getCarListInput() {
        Output.requestCarListInput();
        return Console.readLine();
    }

    public static String getRaceTrialInput() {
        Output.requestRaceTrialInput();
        return Console.readLine();
    }

}
