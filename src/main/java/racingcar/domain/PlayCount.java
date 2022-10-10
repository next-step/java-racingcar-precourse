package racingcar.domain;

import racingcar.common.Number;
import racingcar.exception.RacingCarIllegalArgumentException;

public class PlayCount {

    private final int count;

    public PlayCount(int count) {
        checkValid(count);
        this.count = count;
    }

    private void checkValid(int count) {
        if (count <= Number.ZERO) {
            throw new RacingCarIllegalArgumentException("시도할 회수는 " + Number.ZERO + "보다 작을 수 없습니다. 시도한 회수: " + count);
        }
    }

    public int getCount() {
        return count;
    }
}
