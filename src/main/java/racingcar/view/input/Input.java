package racingcar.view.input;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public String[] enterCarName() {
        return Console.readLine().split(",");
    }

    public int enterTryNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
