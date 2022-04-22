package racingcar.domain;

import racingcar.domain.engine.MoveStatus;

public class Distance {
    private Integer value;

    private Distance(Integer value) {
        this.value = value;
    }

    public static Distance empty() {
        return new Distance(0);
    }

    public static Distance from(int value) {
        return new Distance(value);
    }

    public Integer getValue() {
        return this.value;
    }

    public void update(MoveStatus moveStatus) {
        if (MoveStatus.FORWARD == moveStatus) {
            value++;
        }
    }
}
