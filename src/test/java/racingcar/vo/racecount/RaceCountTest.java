package racingcar.vo.racecount;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.common.error.ErrorMessage;


class RaceCountTest {
    @ParameterizedTest(name = "양수 범위 정상  [{arguments}]")
    @ValueSource(ints = {1, 10, 100})
    public void 양수_범위_정상(int count) {
        assertThat(RaceCount.from(count));
    }

    @ParameterizedTest(name = "양수 범위 예외  [{arguments}]")
    @ValueSource(ints = {-10, -1, 0})
    public void 양수_범위_예외(int count) {
        assertThatThrownBy(() -> RaceCount.from(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.MSG_INVALID_RACE_COUNT.getMessage());
    }

    @ParameterizedTest(name = "toInteger 테스트  [{arguments}]")
    @ValueSource(ints = {1, 10, 100})
    public void toInteger_Test(int count) {
        assertThat(RaceCount.from(count).toInteger()).isEqualTo(count);
    }
}