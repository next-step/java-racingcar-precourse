package racingcar.model.action.selector;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.action.selector.result.ActionSelectorResult;
import racingcar.model.action.selector.result.ForwardOrStayStatus;
import racingcar.model.random.number.generator.GeneratedRandomNumber;

import static org.assertj.core.api.Assertions.assertThat;

public class ForwardOrStayActionSelectorTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void cannotForwardWhenLessThenThreshold(int number) {
        GeneratedRandomNumber generatedRandomNumber = new GeneratedRandomNumber(number);
        ActionSelector actionSelector = new ForwardOrStayActionSelector(generatedRandomNumber);
        ActionSelectorResult actionSelectorResult = actionSelector.select();
        assertThat(actionSelectorResult.nextAction()).isEqualTo(ForwardOrStayStatus.SHOULD_STAY);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void canForwardWhenAtLeastThreshold(int number) {
        GeneratedRandomNumber generatedRandomNumber = new GeneratedRandomNumber(number);
        ActionSelector actionSelector = new ForwardOrStayActionSelector(generatedRandomNumber);
        ActionSelectorResult actionSelectorResult = actionSelector.select();
        assertThat(actionSelectorResult.nextAction()).isEqualTo(ForwardOrStayStatus.CAN_FORWARD);
    }
}
