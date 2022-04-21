package racingcar.game;

public class GameExceptionHandler {
    private static final String PREFIX = "[ERROR] ";

    public static Runnable wrap(Runnable r) {
        return () -> {
            try {
                r.run();
            } catch (Exception e) {
                System.out.println(PREFIX + e.getMessage());
            }
        };
    }
}
