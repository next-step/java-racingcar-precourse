package racinggame.view;

import nextstep.utils.Console;
import racinggame.code.InGameText;

public class RacinggameInputView {
    public static String enterCarList() {
        System.out.println(InGameText.ENTER_CAR_LIST.getValue());

        return Console.readLine();
    }

    public static String enterRound() {
        System.out.println(InGameText.ENTER_ROUND.getValue());

        return Console.readLine();
    }
}
