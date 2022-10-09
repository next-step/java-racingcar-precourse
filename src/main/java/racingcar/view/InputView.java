package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.common.ExcMessage;

public class InputView {

    /** 자동차 이름 입력 */
    public static String inputCarNames(){
        OutputView.println(ExcMessage.INPUT);
        return Console.readLine();
    }

    /** 시도할 회수 입력 */
    public static String tryCar(){
        OutputView.println(ExcMessage.TRY);
        return Console.readLine().trim();
    }
}
