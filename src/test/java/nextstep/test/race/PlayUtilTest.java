package nextstep.test.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.race.utils.CarEngineUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayUtilTest {

    @Test
    @DisplayName("랜덤숫자_VALIDATION")
    void 랜덤숫자_VALIDATION_TRUE() {
        assertThat(CarEngineUtil.validationNumber(5)).isTrue();
    }

    @Test
    @DisplayName("랜덤숫자_VALIDATION")
    void 랜덤숫자_VALIDATION_FALSE_OVER() {
        assertThat(CarEngineUtil.validationNumber(10)).isFalse();
    }

    @Test
    @DisplayName("랜덤숫자_VALIDATION")
    void 랜덤숫자_VALIDATION_FALSE_UNDER() {
        assertThat(CarEngineUtil.validationNumber(-1)).isFalse();
    }

    @ParameterizedTest(name = "이동가능숫자_{index} : {0}")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 엔진가동_가능(int rndNumber) {
        assertThat(CarEngineUtil.canEngineRunConfirm(rndNumber)).isTrue();
    }

    @ParameterizedTest(name = "이동불가숫자_{index} : {0}")
    @ValueSource(ints = {0, 1, 2, 3})
    void 엔진가동_실패(int rndNumber) {
        assertThat(CarEngineUtil.canEngineRunConfirm(rndNumber)).isFalse();
    }

}
