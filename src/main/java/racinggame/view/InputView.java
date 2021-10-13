package racinggame.view;

import nextstep.utils.Console;
import racinggame.common.Const;

public class InputView {
    public static String carNames() {
        System.out.println(Const.GET_CAR_NAMES);
        return Console.readLine();
    }

    public static String tryCount() {
        System.out.println(Const.GET_TRY_NUMBER);
        return Console.readLine();
    }
}
