package domain;

public class Laps {

    public static final String MESSAGE_ERROR_LAPS = "[ERROR] 1 이상의 숫자를 입력해주세요.";
    public static final String REGEX_LAPS = "^[1-9][0-9]*$";
    private final int laps;

    public Laps(String laps) {
        if (!validate(laps)) {
            throw new IllegalArgumentException(MESSAGE_ERROR_LAPS);
        }
        this.laps = Integer.parseInt(laps);
    }

    public int getLaps() {
        return laps;
    }

    public static boolean validate(String laps) {
        return laps.matches(REGEX_LAPS);
    }
}
