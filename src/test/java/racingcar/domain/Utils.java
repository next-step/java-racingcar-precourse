package racingcar.domain;

public class Utils {
    public static void repeat(int count, Runnable runnable) {
        for (int i = 0; i < count; i++) {
            runnable.run();
        }
    }
}
