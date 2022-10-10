package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.common.NaturalNumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AccelValueTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 9})
    @DisplayName("accel 값은 0~9를 사용할 수 있고 값이 변경되지 않는다")
    void test1(int value) {
        AccelValue accel = AccelValue.of(value);

        assertThat(accel.get().isSame(NaturalNumber.of(value))).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    @DisplayName("accel 값이 0보다 작거나 9보다 크면 IllegalArgumentException 이 발생한다")
    void test2(int value) {
        assertThatThrownBy(() -> AccelValue.of(value)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("accel 값이 null 이면 IllegalArgumentException 이 발생한다")
    void test3() {
        assertThatThrownBy(() -> AccelValue.of(null)).isInstanceOf(IllegalArgumentException.class);
    }
}