package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputer() {
        String input = Console.readLine();
        return input;
    }

    public static String[] splitCarName() {
        String input = inputer();
        inputCheck(input.isEmpty(), "[ERROR] input data is empty");
        String[] carNames = input.split(",");

        for (String carName : carNames) {
            inputCheck(carName.length() > 5, "[ERROR] Car name is too long");
        }

        return carNames;
    }

    public static int gameNum() {
        String input = inputer();
        inputCheck(input.isEmpty(), "[ERROR] input data is empty");
        int gameNum = Integer.parseInt(input);
        inputCheck(gameNum < 0, "[ERROR] Input Data Error");
        return gameNum;
    }

    public static void inputCheck(boolean condition, String errorMsg) {
        if (condition) {
            throw new IllegalArgumentException(errorMsg);
        }
    }
}
