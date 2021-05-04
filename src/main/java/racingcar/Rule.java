package racingcar;

public class Rule {

    private static final int FORWARD_NUMBER = 4;

    private Rule() {}

    public static boolean forward(Number number) {
        return number.get() >= FORWARD_NUMBER;
    }
}
