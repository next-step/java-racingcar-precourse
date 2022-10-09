package racingcar.model;


import racingcar.exception.RacingGameIllegalArgumentException;

public final class ExecutionCount {

    private int count;

    protected ExecutionCount() {}

    private ExecutionCount(int count) {
        this.count = count;
    }

    public static ExecutionCount valueOf(String input) {
        if (!isNumber(input) || isNegative(input)) {
            throw new RacingGameIllegalArgumentException("0 이상의 숫자만 입력할 수 있습니다.");
        }
        return new ExecutionCount(Integer.parseInt(input));
    }

    static boolean isNumber(String input) {
        boolean result = true;
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            result = false;
        }
        return result;
    }

    private static boolean isNegative(String input) {
        if (Integer.parseInt(input) < 0) {
            return true;
        }
        return false;
    }

    public int get() {
        return count;
    }

    public void decrease() {
        count--;
    }
}
