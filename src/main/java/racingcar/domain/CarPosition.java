package racingcar.domain;

public class CarPosition {

    public static final int CAR_START_POSITION = 0;

    private int position;

    private CarPosition(int position) {
        this.position = position;
    }

    public static CarPosition init() {
        return new CarPosition(CAR_START_POSITION);
    }

    public static CarPosition from(int position) {
        validate(position);
        return new CarPosition(position);
    }

    private static void validate(int position) {
        if (position < CAR_START_POSITION) {
            throw new IllegalArgumentException(String.format("자동차 위치는 %d보다 작을 수 없습니다.", CAR_START_POSITION));
        }
    }

    public int getPosition() {
        return position;
    }

    public void increase(int count) {
        for (int i = 0; i < count; i++) {
            this.position++;
        }
    }
}
