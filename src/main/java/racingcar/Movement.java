package racingcar;

/**
 * author : citizen103
 */
public class Movement {

    private final String HYPHEN = "-";
    private final int MOVE_CONDITION_NUM = 4;
    private int movement = 0;
    private String hyphen = "";

    public boolean isMove(int condition) {
        return MOVE_CONDITION_NUM <= condition;
    }

    public void move() {
        movement++;
        hyphen += HYPHEN;
    }

    public boolean isMovementSame(int askNum) {
        return movement == askNum;
    }

    public String getHyphen() {
        return this.hyphen;
    }
}
