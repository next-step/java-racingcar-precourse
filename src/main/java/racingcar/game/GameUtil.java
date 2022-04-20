package racingcar.game;

import racingcar.game.car.Car;
import racingcar.game.car.CarNames;
import racingcar.game.car.Cars;
import racingcar.game.util.Console;
import racingcar.game.util.Random;

import java.util.Arrays;
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

    static Cars parseCars(String line) {
        try {
            return new CarNames(Arrays.asList(line.split(","))).mapAndThen(Car::new, Cars::new);
        } catch (Exception e) {
            Console.println(e.getMessage());
        }
        return null;
    }
}
