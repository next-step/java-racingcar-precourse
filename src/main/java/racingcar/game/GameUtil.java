package racingcar.game;

import racingcar.game.util.Random;

import java.util.Collections;

class GameUtil {
    private GameUtil() { }

    static int rollDice() {
        return Random.randomInt(GameConfig.MIN_DICE, GameConfig.MAX_DICE);
    }

    static String repeatString(int n, String s) {
        return String.join("", Collections.nCopies(n, s));
    }
}
