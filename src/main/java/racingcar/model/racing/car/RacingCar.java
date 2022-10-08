package racingcar.model.racing.car;

import racingcar.model.action.selector.ActionSelector;
import racingcar.model.action.selector.ForwardOrStayActionSelector;
import racingcar.model.action.selector.result.ActionSelectorResult;
import racingcar.model.action.selector.result.ForwardOrStayStatus;
import racingcar.model.random.number.generator.GeneratedRandomNumber;

public class RacingCar {
    private final CarName carName;
    private final Advance advance;

    public RacingCar(CarName carName, Advance advance) {
        this.carName = carName;
        this.advance = advance;
    }

    public void playOneRound(GeneratedRandomNumber generatedRandomNumber) {
        ActionSelector actionSelector = new ForwardOrStayActionSelector(generatedRandomNumber);
        ActionSelectorResult actionSelectorResult = actionSelector.select();
        if (actionSelectorResult.nextAction() == ForwardOrStayStatus.CAN_FORWARD) {
            forward();
        }
    }

    public void forward() {
        advance.yes();
    }

    public CarName getCarName() {
        return carName;
    }

    public Advance getAdvance() {
        return advance;
    }
}
