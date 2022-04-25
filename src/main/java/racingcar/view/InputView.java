package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.ViewMessageConst;

public class InputView {
    public static String readCarNames() {
        System.out.println(ViewMessageConst.MESSAGE_READ_CAR_NAMES);
        return Console.readLine();
    }

    public static String readRepeatCount() {
        System.out.println(ViewMessageConst.MESSAGE_READ_REPEAT_COUNT);
        return Console.readLine();
    }
}
