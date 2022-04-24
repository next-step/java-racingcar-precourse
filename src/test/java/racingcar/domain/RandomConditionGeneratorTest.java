package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.generator.RandomConditionGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class RandomConditionGeneratorTest {

    @Test
    void 하나의_컨디션을_생성() {
        RandomConditionGenerator generator = new RandomConditionGenerator();
        Condition condition = generator.generate();
        assertThat(condition.getValue()).isBetween(Condition.MIN_VALUE, Condition.MAX_VALUE);
    }

}