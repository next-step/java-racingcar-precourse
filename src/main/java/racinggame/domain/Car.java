package racinggame.domain;

public class Car {
    private static final int INIT_STEP_NUM = 0;

    private final Name name;
    private Step step;

    public Car(Name name) {
        this.name = name;
        this.step = new Step(INIT_STEP_NUM);
    }

    public Name getName() {
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
