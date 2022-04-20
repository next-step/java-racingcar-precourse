package racingcar.game;

import racingcar.game.util.AbstractMutableList;

public class Turns extends AbstractMutableList<Integer> {
    public Turns(int numTurns) {
        for (int i = 0; i < numTurns; i++) {
            add(i);
        }
    }
}
