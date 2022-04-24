package racingcar.view;


import camp.nextstep.edu.missionutils.Console;
import racingcar.util.MessageUtils;
import racingcar.util.StringUtils;

public class InputView {

    public String inputCarName() {
        System.out.println(MessageUtils.INPUT_CAR_NAME_MESSAGE);
        return Console.readLine();
    }

    public int inputTry() {
        System.out.println(MessageUtils.INPUT_TRY_RACE);
        String tryString = Console.readLine();
        if (StringUtils.isNumber(tryString)) {
            return Integer.parseInt(tryString);
        }
        System.out.println(MessageUtils.INPUT_ERROR_NUMBER_MESSAGE);
        return inputTry();
    }

}
