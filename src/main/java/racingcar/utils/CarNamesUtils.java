package racingcar.utils;

/**
 * @author : choi-ys
 * @date : 2022-04-25 오전 1:58
 */
public class CarNamesUtils {
    public static final String SEPARATOR = ",";

    public static String[] splitByComma(String namesByComma) {
        return namesByComma.split(SEPARATOR);
    }
}
