package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.rule.CarMoveRule;

public class CarMoveRuleTest {
    @DisplayName("자동차 이동 규칙 생성에 성공한다.")
    @Test
    void createCarMoveRuleSuccess_P01() {
        CarMoveRule carMoveRule = new CarMoveRule(1, 0, 4, "-");
        assertThat(carMoveRule.getMoveNum()).isEqualTo(1);
        assertThat(carMoveRule.getStopNum()).isEqualTo(0);
        assertThat(carMoveRule.getMoveMinCondition()).isEqualTo(4);
    }
}
