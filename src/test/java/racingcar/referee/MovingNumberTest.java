package racingcar.referee;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.referee.domain.MovingNumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("이동 횟수")
class MovingNumberTest {

    @DisplayName("이동 횟수 생성")
    @ParameterizedTest
    @ValueSource(strings = "3")
    void createMovingNumber(int number) {
        MovingNumber movingNumber = new MovingNumber(number);
        assertThat(movingNumber).isEqualTo(new MovingNumber(number));
    }

    @DisplayName("이동 횟수는 0보다 커야한다.")
    @ParameterizedTest
    @ValueSource(strings = "-1")
    void createNegativeMovingNumber(int number) {
        assertThatThrownBy(() -> new MovingNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 이동 횟수는 0보다 작을 수 없습니다.");
    }
}
