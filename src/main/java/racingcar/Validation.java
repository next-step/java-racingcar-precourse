package racingcar;

public class Validation {

    private Validation() {}

    public static boolean checkNameLength(String name) {
        return name.length() > 0 && name.length() <= 5;
    }
}
