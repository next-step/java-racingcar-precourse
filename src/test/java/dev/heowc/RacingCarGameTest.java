package dev.heowc;

import dev.heowc.condition.Condition;
import dev.heowc.condition.ConditionGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("게임에 대해 테스트한다.")
class RacingCarGameTest {

    @Test
    void init() {
        final RacingCarGame game = RacingCarGame.init(ConditionGenerator.random(), Condition.of(4));
        assertThat(game).isNotNull();
    }

    @Test
    void successfulRun() {
        final RacingCarGame game = RacingCarGame.init(ConditionGenerator.random(), Condition.of(4));
        game.run(System.out, "a,b,c", 5);
    }

    @ParameterizedTest
    @ValueSource(strings = {",a", "a,,b"})
    void failureRun(String carNames) {
        final RacingCarGame game = RacingCarGame.init(ConditionGenerator.random(), Condition.of(4));
        assertThatThrownBy(() -> {
            game.run(System.out, carNames, 5);
        }).isInstanceOf(NullPointerException.class).hasMessage("name is empty");
    }
}