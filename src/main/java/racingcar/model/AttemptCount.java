package racingcar.model;


public class AttemptCount {
    private final int count;

    public AttemptCount(String count) {
        if (!isValid(count)) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        this.count = Integer.parseInt(count);
    }

    private boolean isValid(String count) {
        if (!isNumeric(count)) {
            return false;
        }
        int c = Integer.parseInt(count);
        if (c <= 0) {
            return false;
        }
        return true;
    }
    private boolean isNumeric(String count) {
        try {
            Integer.parseInt(count);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int getCount() {
        return count;
    }
}
