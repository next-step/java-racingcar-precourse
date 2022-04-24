package racingcar;

public class TryCount {

    private final int value;

    protected TryCount(String input) {
        int value = validate(input);
        this.value = value;
    }

    public static TryCount of(String input) {
        return new TryCount(input);
    }

    private static int validate(String input) {
        final int value = parseInt(input);
        if (value <= 0) {
            throw new InvalidTryCountException(input);
        }
        return value;
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ignored) {
            throw new InvalidTryCountException(input);
        }
    }

    public void attempt(Runnable runnable) {
        for (int i = 0; i < value; i++) {
            runnable.run();
        }
    }
}
