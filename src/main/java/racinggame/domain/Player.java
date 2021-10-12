package racinggame.domain;

import nextstep.utils.Console;

public class Player {
    public AttemptNumber inputAttemptNumber() {
        return new AttemptNumber(Integer.parseInt(Console.readLine()));
    }

    public String inputNames() {
        return Console.readLine();
    }
}
