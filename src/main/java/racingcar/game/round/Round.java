package racingcar.game.round;

import racingcar.common.Input;
import racingcar.game.Printer;

public class Round {

    private final int round;

    private Round(int round) {
        this.round = round;
    }

    public static Round fromConsole() {
        try {
            Printer.initRound();

            return new Round(
                    Input.fromConsole().toInteger());
        } catch (IllegalArgumentException e) {
            return fromConsole();
        }
    }

    public int get() {
        return this.round;
    }

}
