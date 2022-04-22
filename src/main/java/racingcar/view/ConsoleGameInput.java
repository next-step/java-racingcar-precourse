package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleGameInput implements GameInput {
    @Override
    public String read() {
        return Console.readLine();
    }
}
