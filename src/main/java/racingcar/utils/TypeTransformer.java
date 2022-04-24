package racingcar.utils;

public class TypeTransformer {
    /**
     * method override -> seperator default value
     */
    public static String[] changeString2Array(String input) {
        return input.split(",");
    }
    public static String[] changeString2Array(String input, String seperator) {
        return input.split(seperator);
    }
}
