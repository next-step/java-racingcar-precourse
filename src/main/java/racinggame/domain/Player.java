package racinggame.domain;

import nextstep.utils.Console;

public class Player {
    public Step inputStep() {
        return new Step(Integer.parseInt(Console.readLine()));
    }
}
