package racingcar.domain;

public class Times {
    private static final String ILLEGAL_ARGUMENT_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 한다.";
    private int times;

    public Times(String input) {
        this.times = parseInteger(input);
    }

    public int parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
        }
    }

    public int getTimes() {
        return times;
    }
}
