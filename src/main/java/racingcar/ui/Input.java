package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String receiveCarNames() {
        Output.printReceiveCarNames();
        return Console.readLine();
    }

    public static String receiveCount() {
        Output.printReceiveCount();
        return Console.readLine();
    }
}
