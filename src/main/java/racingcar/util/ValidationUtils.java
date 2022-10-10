package racingcar.util;

public class ValidationUtils {
    public static final int MIN_NO = 0;
    public static final int MAX_NO = 9;
    public static final int MIN_NAME_LENGTH = 0;
    public static final int MAX_NAME_LENGTH = 5;
    public static final String INPUT_SPLIT_SEPARATOR = ",";

    public static boolean validNo(int no) throws IllegalArgumentException {
        if (no < MIN_NO || no > MAX_NO) {
            throw new IllegalArgumentException();
        }

        return true;
    }

    public static boolean validName(String name) {
        return name.length() > MIN_NAME_LENGTH && name.length() <= MAX_NAME_LENGTH;
    }

    public static boolean validNames(String racingCarNamesInput) throws IllegalArgumentException {
        String[] names = racingCarNamesInput.split(INPUT_SPLIT_SEPARATOR);

        for (String name : names) {
            checkNameLength(name);
        }

        return true;
    }

    private static void checkNameLength(String name) {
        if (name.length() > 5 || name.length() < 1) {
            throw new IllegalArgumentException();
        }
    }
}
