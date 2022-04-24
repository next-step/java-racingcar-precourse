package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import racingcar.Constant;

public class InputView {

    private InputView() {}

    public static String getCarNames() {
        System.out.println(Constant.PARTICIPATING_CAR_NAME_INPUT_MESSAGE);
        return Console.readLine();
    }

    public static String getRaceCount() {
        System.out.println(Constant.RACE_ROUND_INPUT_MESSAGE);
        return Console.readLine();
    }


}
