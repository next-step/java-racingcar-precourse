package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.message.Message;

public class InputView {
    private final Message message;

    public InputView(Message message) {
        this.message = message;
    }

    public String inputCarsNames() {
        print(message.inputCarsNames());
        return input();
    }

    public String inputMoveCount() {
        print(message.inputMoveCount());
        return input();
    }

    private String input() {
        return Console.readLine();
    }

    private void print(String message) {
        System.out.println(message);
    }
}
