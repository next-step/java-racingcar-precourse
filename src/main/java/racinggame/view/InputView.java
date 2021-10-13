package racinggame.view;

import nextstep.utils.Console;

public class InputView {
    private static final String CAR_NAMES_INPUT_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACE_NUMBER_INPUT_MSG = "시도할 회수는 몇회인가요?";

    public static String getCarNamesInput() {
        System.out.println(CAR_NAMES_INPUT_MSG);
        return Console.readLine();
    }

    public static String getRaceNumberInput() {
        System.out.println(RACE_NUMBER_INPUT_MSG);
        return Console.readLine();
    }

    public static void printInputErrorMsg(String errorMessage) {
        System.out.println(errorMessage);
    }
}

