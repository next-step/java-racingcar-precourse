package racingcar.domain.car;

public class Position {

    private final int position;
    public static final int MIN_POSITION = 0;
    public static final String NOT_ALLOWED_NUMBER = "음수가 입력될 수 없습니다.";

    public Position(int position) {
        this.position = validate(position);
    }

    private int validate(int position) {
        if (position < MIN_POSITION) {
            throw new IllegalArgumentException(NOT_ALLOWED_NUMBER);
        }
        return position;
    }

    public int getPosition() { return position; }

    public int getMaxPosition(int comparePosition) {
        return Math.max(comparePosition, this.position);
    }

    public boolean isMaxPosition(int maxPosition) {
        return this.position == maxPosition;
    }

}
