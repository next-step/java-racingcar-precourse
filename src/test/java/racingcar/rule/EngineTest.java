package racingcar.rule;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EngineTest {
    private Engine engine = new Engine();
    private int ENGINE_FORWARD_ENERGY = 4;

    @DisplayName("에너지가 4 이상이면 전진한다")
    @Test
    void forwardWhenMoreThan4() {
        //given
        int moreThan4 = ENGINE_FORWARD_ENERGY;

        //when
        Energy energy = Energy.from(moreThan4);
        Move move = engine.powerBy(energy);

        //then
        assertThat(move.isForward()).isTrue();
    }

    @DisplayName("에너지가 4 미만이면 멈춤이다")
    @Test
    void stopWhenLessThan4() {
        //given
        int lessThan4 = ENGINE_FORWARD_ENERGY - 1;

        //when
        Energy energy = Energy.from(lessThan4);
        Move move = engine.powerBy(energy);

        //then
        assertThat(move.isStop()).isTrue();
    }
}
