package racinggame.domain;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int INIT_STEP_NUM = 0;

    private final String name;
    private Step step;

    public Car(String name) {
        if (name == null || name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("5글자 이상 또는 비어있는 이름으로 자동차를 생성할 수 없습니다.");
        }
        this.name = name;
        this.step = new Step(INIT_STEP_NUM);
    }

    public String getName() {
        return name;
    }

    public Step getStep() {
        return step;
    }

    public void moveForwardOrStop(MoveStatus moveStatus) {
        if (moveStatus.isForward()) {
            step.forward();
        }
    }
}
