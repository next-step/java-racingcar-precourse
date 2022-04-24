package racingcar.view;

public class RoundCount {
    private final int roundCount;

    public RoundCount(String roundCount) {
        validEmpty(roundCount);
        validNumber(roundCount);
        validLessZero(roundCount);
        this.roundCount = Integer.parseInt(roundCount);
    }

    private void validEmpty(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("빈 값은 입력할 수 없습니다.");
        }
    }

    private void validNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다");
        }
    }

    private void validLessZero(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다");
        }
    }

    public int getRoundCount() {
        return roundCount;
    }
}
