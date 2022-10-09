package racingcar.domain;

public class MovementCount {
    private static final Integer MOVING_CRITERION = 4;
    private Integer count;

    public MovementCount() {
        this.count = 0;
    }

    public void move(Integer moveNumber) {
        if (moveNumber >= MOVING_CRITERION) {
            this.count++;
        }
    }

    public Integer getCount() {
        return this.count;
    }
}
