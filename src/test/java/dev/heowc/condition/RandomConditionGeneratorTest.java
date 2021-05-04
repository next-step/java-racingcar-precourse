package dev.heowc.condition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("랜덤 조건 생성기에 대해 테스트한다.")
class RandomConditionGeneratorTest {

    @DisplayName("랜덤한 조건을 생성한다.")
    @Test
    void create() {
        final ConditionGenerator conditionGenerator = new RandomConditionGenerator();
        assertThat(conditionGenerator.generate()).isNotNull();
    }
}