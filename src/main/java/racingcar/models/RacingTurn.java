package racingcar.models;

import racingcar.common.exceptions.IllegalArgumentException;

public class RacingTurn {

    private final int turnCount;

    public RacingTurn(String turnString) {
        try {
            int turnCount = Integer.parseInt(turnString);
            this.valid(turnCount);
            this.turnCount = turnCount;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("턴 수를 숫자로 입력해주세요.");
        }
    }

    private void valid(int turnCount) {
        if (turnCount <= 0)
            throw new IllegalArgumentException("1 이상의 턴 수를 입력해주세요.");
    }

    public int get() {
        return this.turnCount;
    }
}
