package racingcar.vo.racenumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.common.error.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceNumberTest {

    @ParameterizedTest(name = "일부터 구 범위 정상  [{arguments}]")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    public void 일_부터_구_범위_정상(int number) {
        assertThat(RaceNumber.from(number));
    }

    @ParameterizedTest(name = "일 부터 구 범위 예외  [{arguments}]")
    @ValueSource(ints = {-10, -1, 10, 100})
    public void 일_부터_구_범위_예외(int number) {
        assertThatThrownBy(() -> RaceNumber.from(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.MSG_INVALID_NUMBER.getMessage());
    }

    @DisplayName("compareTo 양수 테스트")
    @Test
    public void compareTo_양수_테스트() {
        assertThat(RaceNumber.from(5).compareTo(RaceNumber.from(1))).isPositive();
    }

    @DisplayName("compareTo 음수 테스트")
    @Test
    public void compareTo_음수_테스트() {
        assertThat(RaceNumber.from(3).compareTo(RaceNumber.from(8))).isNegative();
    }
}