package racingcar.input;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.input.InputPrintMessage;

public class Input {
    private final InputPrintMessage inputPrintMessage;

    public Input(InputPrintMessage inputPrintMessage) {
        this.inputPrintMessage = inputPrintMessage;
    }

    public String getMessage() {
        this.inputPrintMessage.messageOutput();
        return Console.readLine();
    }
}
