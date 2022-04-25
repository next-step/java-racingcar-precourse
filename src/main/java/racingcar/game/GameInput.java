package racingcar.game;

import racingcar.game.car.CarName;
import racingcar.game.car.CarNames;
import racingcar.game.internal.Strings;
import racingcar.game.util.Console;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class GameInput {
    private static final String EXCEPTION_MESSAGE_PREFIX = "[ERROR] ";

    static String readLineWithPrompt(String s) {
        Console.print(s);
        return Console.readLine();
    }

    private static class ObjectBoolean<T> {
        private final T obj;
        private final Boolean bool;
        private ObjectBoolean(T obj, Boolean bool) {
            this.obj = obj;
            this.bool = bool;
        }
    }

    private static <T, U> ObjectBoolean<T> wrapHandleException(Supplier<U> supplier,
                                                               Function<U, T> function,
                                                               Predicate<T> validator) {
        try {
            T ret = function.apply(supplier.get());
            return new ObjectBoolean<>(ret, validator.test(ret));
        } catch (IllegalArgumentException e) {
            Console.println(EXCEPTION_MESSAGE_PREFIX + e.getMessage());
        }
        return new ObjectBoolean<>(null, false);
    }

    private static <T, U> T getUntilValid(Supplier<U> supplier,
                                          Function<U, T> function,
                                          Predicate<T> validator) {
        T result = null;
        boolean done = false;
        while (!done) {
            ObjectBoolean<T> ret = wrapHandleException(supplier, function, validator);
            result = ret.obj;
            done = ret.bool;
        }
        return result;
    }

    private static <T> Supplier<T> readLineUntilValid(String prompt,
                                                      Function<String, T> function,
                                                      Predicate<T> validator) {
        return () -> getUntilValid(
                () -> readLineWithPrompt(prompt),
                function,
                validator
        );
    }

    static CarNames parseCarNames(String line) {
        return new Strings(line.split(","))
                .mapAndWrap(CarName::new, CarNames::new);
    }

    private static boolean validateCarNames(CarNames carNames) {
        if (carNames.size() < GameConfig.MIN_CARS) {
            throw new IllegalArgumentException(GameConfig.MIN_CARS + " cars are needed at least");
        }
        return true;
    }

    static CarNames readCarNames() {
        return readLineUntilValid(
                GameMessage.PROMPT_INPUT_CAR_NAMES.get(),
                GameInput::parseCarNames,
                GameInput::validateCarNames
        ).get();
    }

    private static int parseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("cannot parse '" + s + "'");
        }
    }

    private static boolean validateNumTurns(int num) {
        if (num < 1) {
            throw new IllegalArgumentException("input must be 1 at least");
        }
        return true;
    }

    static int readNumTurns() {
        return readLineUntilValid(
                GameMessage.PROMPT_INPUT_NUMBER_OF_TURNS.get(),
                GameInput::parseInt,
                GameInput::validateNumTurns
        ).get();
    }
}
