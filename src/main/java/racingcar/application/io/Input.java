package racingcar.application.io;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public String carNameInput() {
        return Console.readLine();
    }

    public int round() {
        return Integer.parseInt(Console.readLine());
    }
}