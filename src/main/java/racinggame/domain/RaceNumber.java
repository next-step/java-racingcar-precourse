package racinggame.domain;

import java.util.regex.Pattern;

public class RaceNumber {

    private static final Pattern isNumber = Pattern.compile("^[0-9]*?");
    private final int value;

    public RaceNumber(String value) {
        validateNumber(value);
        this.value = convertToInteger(value);
    }

    public int getValue() {
        return value;
    }

    public static RaceNumber of(String value) {
        return new RaceNumber(value);
    }

    public void validateNumber(String value) {
        if (!isNumber.matcher(value).matches()) {
            throw new IllegalArgumentException(ErrorCode.IS_NOT_NUMBER.getMessage());
        }
    }

    private int convertToInteger(String value) {
        return Integer.parseInt(value);
    }




}
