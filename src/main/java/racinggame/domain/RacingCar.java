package racinggame.domain;

import racinggame.utils.Message;
import racinggame.utils.MessageBuilder;

public class RacingCar {
    private static final int INIT_STEP_NUM = 0;
    private static final Message SPACE_COLON_MESSAGE = new Message(" : ");

    private final CarName carName;
    private Step step;

    public RacingCar(CarName carName) {
        this.carName = carName;
        this.step = new Step(INIT_STEP_NUM);
    }

    public CarName getCarName() {
        return carName;
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
        return new MessageBuilder(carName.makeNameMessage())
            .append(SPACE_COLON_MESSAGE)
            .append(step.makeStepMessage())
            .toMessage();
    }
}
