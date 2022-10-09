package racingcar;

public class Utils {
    public static String getDistanceDash(int count) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < count; i++) {
            result.append("-");
        }

        return result.toString();
    }
}
