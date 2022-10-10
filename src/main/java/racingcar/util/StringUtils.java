package racingcar.util;


public class StringUtils {

    public static String repeat(String s, int repeatCount) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < repeatCount; i++) {
            sb.append(s);
        }
        return sb.toString();
    }
}
