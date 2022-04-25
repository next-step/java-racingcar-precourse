package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.ValidCommonConditionEnum;

public class InputView {

    public static String getCarsNameInput() {
        System.out.println(ValidCommonConditionEnum.INPUT_CAR_NAME_MSG.getValue());
        return Console.readLine();
    }

    public static String getPlayRepeatInput() {
        System.out.println(ValidCommonConditionEnum.INPUT_REPEAT_CNT_MSG.getValue());
        return Console.readLine();
    }
}
