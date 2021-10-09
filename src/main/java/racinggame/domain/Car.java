package racinggame.domain;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int step;

    public Car(String name) {
        if (name == null || name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("5글자 이상 또는 비어있는 이름으로 자동차를 생성할 수 없습니다.");
        }
        this.name = name;
        this.step = 0;
    }

    public String getName() {
        return name;
    }

    public int getStep() {
        return step;
    }

    public void moveForwardOrStop(MoveStatus moveStatus) {
        if (moveStatus.isForward()) {
            step++;
        }
    }
}
