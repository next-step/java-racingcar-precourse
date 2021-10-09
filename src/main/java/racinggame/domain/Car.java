package racinggame.domain;

public class Car {
    private static final int MIN_NUM = 0;
    private static final int MAX_NUM = 9;
    private static final int MIN_MOVE_FORWARD_NUMBER = 4;

    private final String name;
    private int step;

    public Car(String name) {
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("5글자 이상 또는 비어있는 이름으로 자동차를 생성할 수 없습니다.");
        }
        this.name = name;
        this.step = 0;
    }

    public String getName() {
        return name;
    }

    public void moveForward() {
        step++;
    }

    public int getStep() {
        return step;
    }

    public void moveForwardOrStop(int i) {
        if (i < MIN_NUM || i > MAX_NUM) {
            throw new IllegalArgumentException("0에서 9 사이의 숫자로만 이동할지 판단 가능합니다.");
        }
        if (i >= MIN_MOVE_FORWARD_NUMBER) {
            step++;
        }
    }
}
