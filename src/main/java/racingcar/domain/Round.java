package racingcar.domain;

public class Round {
    private static final int ZERO = 0;
    private final int round;

    public Round(int round) {
        this.round = round;
    }

    public static Round valueOf(String s) {
        int round;
        try {
            round = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 받을 수 있습니다.");
        }
        validPositive(round);
        return new Round(round);
    }

    private static void validPositive(int round) {
        if (round < ZERO) {
            throw new IllegalStateException("횟수는 음수가 올 수 없습니다.");
        }
    }

    public int getRound() {
        return round;
    }
}
