package racingcar.game;

import racingcar.game.util.AbstractMutableList;

public class Turns extends AbstractMutableList<Integer> {
    public Turns(int numTurns) {
        for (int i = 0; i < numTurns; i++) {
            add(i);
        }
    }

    public Turns(String stringNum) {
        this(parseInt(stringNum));
    }

    private static int parseInt(String s) {
        int num;
        try {
            num = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("cannot parse '" + s + "'");
        }
        return num;
    }
}
