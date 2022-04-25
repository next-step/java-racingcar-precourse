package racingcar.racing;

import java.util.Objects;
import racingcar.utils.NullUtils;

public class RacingMoveCount {
    private Integer moveCount;

    public RacingMoveCount(Integer moveCount) {
        this.validMoveCount(moveCount);
        this.moveCount = moveCount;
    }

    private void validMoveCount(Integer moveCount) {
        NullUtils.validNullArgument(moveCount, "MoveCount는 Null일수 없습니다.");
        if (moveCount < 0) {
            throw new IllegalArgumentException("[ERROR] moveCount는 음수일 수 없습니다. now : " + moveCount);
        }
    }

    public Integer moveCount() {
        return this.moveCount;
    }

    public boolean lessThen(RacingMoveCount racingMoveCount) {
        return this.moveCount < racingMoveCount.moveCount;
    }

    public void plus() {
        this.moveCount++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingMoveCount that = (RacingMoveCount) o;
        return Objects.equals(moveCount, that.moveCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moveCount);
    }

    @Override
    public String toString() {
        return "RacingMoveCount{" +
                "moveCount=" + moveCount +
                '}';
    }
}
