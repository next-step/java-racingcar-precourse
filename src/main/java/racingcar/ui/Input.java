package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String[] receiveCarNameListInput() {
        Output.printCarNameListInput();
        return Console.readLine().split(",");
    }

    public static String receiveAttemptInput() {
        Output.printAttemptInput();
        return Console.readLine();
    }
}
