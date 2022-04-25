package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.common.error.ErrorMessage;

class NameTest {

    private static final int MAX_NAME_LENGTH = 5;

    @ParameterizedTest(name = "5자 이상 자동차 이름 예외 테스트")
    @ValueSource(strings = {"BestCar", "FantasticCar", "AmazingCar"})
    public void 다섯글자_이상_예외(String name) {
        assertThatThrownBy(() -> Name.from(name)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(ErrorMessage.MSG_INVALID_OVER_NAME_LENGTH.getMessage(), MAX_NAME_LENGTH));
    }

    @DisplayName("Null 예외 테스트")
    @Test
    public void Null_예외() {
        assertThatThrownBy(() -> Name.from(null)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.MSG_INVALID_OVER_NAME_NULL.getMessage());
    }

    @DisplayName("빈 스트링 예외 테스트")
    @Test
    public void 빈스트링_예외() {
        assertThatThrownBy(() -> Name.from("  ")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.MSG_INVALID_OVER_NAME_EMPTY.getMessage());
    }

    @ParameterizedTest(name = "동일한 값 비교")
    @ValueSource(strings = {"Car1", "Car2", "Car3"})
    public void 동일한_값_비교(String name) {
        Name compare1 = Name.from(name);
        Name compare2 = Name.from(name);

        assertThat(compare1.equals(compare2)).isTrue();
    }
}