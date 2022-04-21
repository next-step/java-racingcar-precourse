package racingcar.game;

import racingcar.game.car.CarName;
import racingcar.game.car.CarNames;
import racingcar.game.internal.Strings;
import racingcar.game.util.Console;
import racingcar.game.util.Random;

import java.util.Collections;

class GameUtil {
    private GameUtil() { }

    static String readLineWithPrompt(String s) {
        Console.print(s);
        return Console.readLine();
    }

    static int rollDice() {
        return Random.randomInt(GameConfig.MIN_DICE, GameConfig.MAX_DICE);
    }

    static String repeatString(int n, String s) {
        return String.join("", Collections.nCopies(n, s));
    }

    static CarNames parseCarNames(String line) {
        return new Strings(line.split(",")).mapAndCollect(CarName::new, CarNames::new);
    }

    static int parseInt(String s) {
        int num;
        try {
            num = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("cannot parse '" + s + "'");
        }
        return num;
    }
}
