package racingcar;

public class Rule {

    private static final int FORWARD_NUMBER = 4;

    private Rule() {}

    public static boolean forward(int number) {
        return number >= FORWARD_NUMBER;
    }
}
