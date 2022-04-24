package racingcar.model;

public class Attempts {

    private int attempt;

    public Attempts(String attempt) {
        validate(attempt);
        this.attempt = Integer.parseInt(attempt);
    }

    public void validate(String attempt) {
        if (!attempt.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
        }
    }

    public int getAttempt() {
        return attempt;
    }
}
