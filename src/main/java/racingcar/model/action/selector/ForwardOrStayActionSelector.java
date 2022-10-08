package racingcar.model.action.selector;

import racingcar.model.action.selector.result.ActionSelectorResult;
import racingcar.model.action.selector.result.ForwardOrStayActionSelectorResult;
import racingcar.model.random.number.generator.GeneratedRandomNumber;

public class ForwardOrStayActionSelector implements ActionSelector {
    private static final int FORWARD_OR_STOP_THRESHOLD = 4;
    private final GeneratedRandomNumber generatedRandomNumber;

    public ForwardOrStayActionSelector(GeneratedRandomNumber generatedRandomNumber) {
        this.generatedRandomNumber = generatedRandomNumber;
    }

    @Override
    public ActionSelectorResult select() {
        if (generatedRandomNumber.getValue() < FORWARD_OR_STOP_THRESHOLD) {
            return new ForwardOrStayActionSelectorResult(false);
        }
        return new ForwardOrStayActionSelectorResult(true);
    }

    public GeneratedRandomNumber getGeneratedRandomNumber() {
        return generatedRandomNumber;
    }
}
