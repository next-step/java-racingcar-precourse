package racingcar.domain;

public class Position {

    private int position;

    public Position() {
        this.position = 0;
    }

    public Position(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("position은 1이상의 정수값이어야 합니다.");
        }
    }

    public void moveForward(int randomNumber) {
        if (randomNumber >= 4) {
            this.position += 1;
        }
    }

    public int getPosition() {
        return position;
    }
}
