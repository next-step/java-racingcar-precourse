package racingcar.domain;

/**
 * 이동 횟수
 *
 * @author suji
 * @date 2022-04-23
 **/
public class MovementCount {

    private static final int FORWARD_CONDITION = 4;

    private Integer count;

    public MovementCount() {
        this.count = 0;
    }

    public void movingForward(int moveNumber) {
        if (moveNumber >= FORWARD_CONDITION) {
            this.count++;
        }
    }

    public Integer getCount() {
        return count;
    }
}
