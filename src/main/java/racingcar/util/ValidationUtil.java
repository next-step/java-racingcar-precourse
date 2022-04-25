package racingcar.util;

/**
 * Created by victorsung.
 * Date: 2022/04/25
 * Time: 8:36 PM
 */
public class ValidationUtil {

    public static final int MIN = 0;
    public static final int MAX = 9;

    public static boolean checkNo(int no) {
        return no >= MIN && no <= MAX;
    }

    public static boolean checkName(String name) {
        return name.length() <= 5;
    }

}
