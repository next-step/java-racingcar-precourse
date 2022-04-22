package racingcar.game;

import racingcar.game.car.CarName;
import racingcar.game.car.CarNames;
import racingcar.game.internal.Strings;
import racingcar.game.util.Console;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import java.util.function.Supplier;

class GameInput {
    private static final String EXCEPTION_MESSAGE_PREFIX = "[ERROR] ";

    static String readLineWithPrompt(String s) {
        Console.print(s);
        return Console.readLine();
    }

    private static <T, U> T wrapTryCatch(Supplier<U> supplier,
                                         Function<U, T> function,
                                         Function<T, Boolean> validator,
                                         AtomicBoolean validationResult) {
        T result = null;
        try {
            result = function.apply(supplier.get());
            validationResult.set(validator.apply(result)); // side effect
        } catch (Exception e) {
            Console.println(EXCEPTION_MESSAGE_PREFIX + e.getMessage());
        }
        return result;
    }

    private static <T, U> T loopUntilDone(Supplier<U> supplier,
                                          Function<U, T> function,
                                          Function<T, Boolean> validator) {
        T result = null;
        AtomicBoolean done = new AtomicBoolean(false);
        while (!done.get()) {
            result = wrapTryCatch(supplier, function, validator, done);
        }
        return result;
    }

    static CarNames parseCarNames(String line) {
        return new Strings(line.split(","))
                .mapAndCollect(CarName::new, CarNames::new);
    }

    private static boolean validateCarNames(CarNames carNames) {
        if (carNames.size() < GameConfig.MIN_CARS) {
            throw new IllegalArgumentException(GameConfig.MIN_CARS + " cars are needed at least");
        }
        return true;
    }

    static CarNames inputCarNames() {
        return loopUntilDone(
                () -> readLineWithPrompt(GameMessage.PROMPT_INPUT_CAR_NAMES.get()),
                GameInput::parseCarNames,
                GameInput::validateCarNames
        );
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

    private static boolean validateNumTurns(int num) {
        if (num < 1) {
            throw new IllegalArgumentException("input must be 1 at least");
        }
        return true;
    }

    static int inputNumTurns() {
        return loopUntilDone(
                () -> readLineWithPrompt(GameMessage.PROMPT_INPUT_NUMBER_OF_TURNS.get()),
                GameInput::parseInt,
                GameInput::validateNumTurns
        );
    }
}
