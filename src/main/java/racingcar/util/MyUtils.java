package racingcar.util;

import java.util.NoSuchElementException;
import java.util.concurrent.Callable;

public class MyUtils {

    public static <V> V retryUntilNotNull(Callable<V> callable) {
        V value;
        do {
            value = tryOrNull(callable);
        } while (value == null);
        return value;
    }

    private static <V> V tryOrNull(Callable<V> callable) {
        try {
            return callable.call();
        } catch (NoSuchElementException e) {
            // Console 에서 인풋이 없는 경우를 무시하기 위한 catch 절
            throw e;
        } catch (Throwable t) {
            System.out.println("[ERROR] " + t.getMessage());
            return null;
        }
    }

    public static StringBuilder repeatBuilder(String str, int repeat) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < repeat; i++) {
            stringBuilder.append(str);
        }
        return stringBuilder;
    }

    public static boolean lengthIn(String str, int minLength, int maxLength) {
        return str.length() >= minLength && str.length() <= maxLength;
    }

    public static boolean lengthNotIn(String str, int minLength, int maxLength) {
        return !lengthIn(str, minLength, maxLength);
    }

}
