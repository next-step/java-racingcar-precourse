package racingcar.rule;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("RandomConditionGenerator에 대해 테스트한다.")
class RandomConditionGeneratorTest {

    final RandomConditionGenerator conditionGenerator = RandomConditionGenerator.INSTANCE;

    @DisplayName("성공적으로 Condition을 생성한다.")
    @Test
    void test() {
        assertRandomNumberInRangeTest(() -> {
            final Condition condition = conditionGenerator.generate(Car.of("dummy"));
            assertThat(condition).isEqualTo(Condition.of(1));
        }, 1);
    }
}
