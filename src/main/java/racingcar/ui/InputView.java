package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;

public final class InputView {
    private static final String CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String LAP_MESSAGE = "시도할 회수는 몇회인가요?";

    private InputView() {
    }

    public static String inputCarNames() {
        print(CAR_NAMES_MESSAGE);
        return read();
    }

    public static String inputLapCount() {
        print(LAP_MESSAGE);
        return read();
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static String read() {
        return Console.readLine();
    }
}
