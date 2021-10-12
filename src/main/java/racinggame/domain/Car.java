package racinggame.domain;

public class Car {
    private static final int INIT_STEP_NUM = 0;
    private static final Message SPACE_COLON_MESSAGE = new Message(" : ");

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

    public Message makeStatusMessage() {
        return new MessageBuilder(name.makeNameMessage())
            .append(SPACE_COLON_MESSAGE)
            .append(step.makeStepMessage())
            .toMessage();
    }
}
