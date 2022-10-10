package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class MovementTest {

    @DisplayName("자동자 경주를 진행할 횟수를 나타내는 클래스를 정상적으로 생성한다.")
    @Test
    void construct() {
        Movement movement = new Movement("5");
        assertThat(movement).isNotNull();
    }

    @DisplayName("숫자가 아닌 값으로 경기 횟수를 입력하면 예외가 발생한다.")
    @Test
    void constructWithNotANumber() {
        assertThatThrownBy(() -> new Movement("A")).isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("경기 횟수로 양수가 아닌 값을 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    void constructWithNotPositiveNumber(String round) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Movement(round))
                .withMessageContaining("자동차 경주를 진행할 횟수는 1 이상이어야 합니다.");
    }

    @DisplayName("레이싱 경주를 지속여부를 판단한다. (지속)")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void continuable_true(String round) {
        Movement movement = new Movement(round);
        assertTrue(movement.continuable());
    }

    @DisplayName("cache 된 값으로 응답받는지 확인한다.")
    @Test
    void move() {
        Movement movement1 = new Movement("2");
        Movement movement2 = new Movement("2");

        assertNotSame(movement1, movement2);
        assertSame(movement1.move(), movement1.move());
    }
}
