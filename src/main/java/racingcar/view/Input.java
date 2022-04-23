package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Input {
    private final InputUtil inputUtil;
    private static Input input;

    private Input() {
        this.inputUtil = InputUtil.getInstance();
    }

    public static Input getInstance() {
        if(input == null) {
            input = new Input();
        }
        return input;
    }

    public List<String> getCarNames() {
        String input = Console.readLine();
        return inputUtil.split(input);
    }

    public int getRound() {
        String input = Console.readLine();
        return inputUtil.parse(input);
    }
}
