package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racingcar.constants.EngineOperateType;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RandomeEngineTest {
    RandomEngine engine;

    @BeforeEach
    void init() {
        engine = RandomEngine.getInstance();
    }

    @RepeatedTest(10)
    @DisplayName("1~9 사이 랜덤 수 구하기 10번 반복")
    public void 일_구_사이_랜덤_수_구하기() throws Exception {
        // given
        List<Integer> unitNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        // when
        int number = engine.getRandomNumber();
        // then
        assertThat(unitNumbers.contains(number)).isTrue();
    }

    @Test
    public void 사_이상_전진_삼_이하_멈춤() throws Exception {
        // when
        EngineOperateType accelerate1 = toEngineType(engine.isAccelerate(9));
        EngineOperateType accelerate2 = toEngineType(engine.isAccelerate(4));
        EngineOperateType break1 = toEngineType(engine.isAccelerate(1));
        EngineOperateType break2 = toEngineType(engine.isAccelerate(3));
        // then
        assertThat(accelerate1).isEqualTo(EngineOperateType.ACCELERATE);
        assertThat(accelerate2).isEqualTo(EngineOperateType.ACCELERATE);
        assertThat(break1).isEqualTo(EngineOperateType.BREAK);
        assertThat(break2).isEqualTo(EngineOperateType.BREAK);
    }

    private EngineOperateType toEngineType(boolean isAccelerate) {
        return isAccelerate ? EngineOperateType.ACCELERATE
                    : EngineOperateType.BREAK;
    }
}
