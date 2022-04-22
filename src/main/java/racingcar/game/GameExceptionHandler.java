package racingcar.game;

import racingcar.game.util.Console;

public class GameExceptionHandler {
    private static final String PREFIX = "[ERROR] ";

    private static void printException(Exception e) {
        Console.println(PREFIX + e.getMessage());
    }

    private static void handleException(Runnable r) {
        try {
            r.run();
        } catch (Exception e) {
            printException(e);
        }
    }

    public static Runnable wrap(Runnable r) {
        return () -> handleException(r);
    }
}
