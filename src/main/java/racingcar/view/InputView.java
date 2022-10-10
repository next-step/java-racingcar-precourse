package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public final class InputView {

    private static final String CAR_NAME_DELIMITER = ",";
    private static final String CAR_NAME_DELIMITER_NAME = "쉼표";

    private InputView() {
    }

    public static String getCarNames() {
        printCarNamesRequest();
        return getUserInput();
    }

    public static String getPlayCount() {
        printPlayCountRequest();
        return getUserInput();
    }

    private static void printCarNamesRequest() {
        System.out.println(createCarNamesRequestMessage());
    }

    private static void printPlayCountRequest() {
        System.out.println(createPlayCountRequestMessage());
    }

    private static String createCarNamesRequestMessage() {
        return String.format("경주할 자동차 이름을 입력하세요.(%s)", createCarNamesDelimMessage());
    }

    private static String createCarNamesDelimMessage() {
        return String.format("이름은 %s(%s) 기준으로 구분", CAR_NAME_DELIMITER_NAME, CAR_NAME_DELIMITER);
    }

    private static String createPlayCountRequestMessage() {
        return "시도할 회수는 몇회인가요?";
    }

    private static String getUserInput() {
        return Console.readLine().trim();
    }
}
