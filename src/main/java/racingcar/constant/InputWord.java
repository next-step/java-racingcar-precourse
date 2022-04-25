package racingcar.constant;

public class InputWord {

    public static final String ZERO = "0";
    public static final String COMMA = ",";
    public static final int NOT_EXIST = -1;

    private InputWord() {
        throw new IllegalStateException(ErrorMessage.CONSTANT_CLASS);
    }
}
