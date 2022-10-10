package racingcar.domain;

public class Move {

    public static final int FORWARD_CRITERIA = 4;
    private final int Min_NUMBER = 0;
    private final int MAX_NUMBER = 9;
    private boolean isMoved = false;

    public void execute(int number) {
        if (number < Min_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("0이상 9이하의 값을 입력해 주세요");
        }
        if (number >= FORWARD_CRITERIA) {
            move();
        }
        if (number < FORWARD_CRITERIA) {
            stop();
        }
    }

    public boolean isMoved() {
        return isMoved;
    }

    public void move() {
        isMoved = true;
    }

    private void stop() {
        isMoved = false;
    }
}
