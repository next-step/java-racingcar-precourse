package racingcar.domain.racing.car.accelerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class PowerTest {
    @Nested
    @DisplayName("유효성 검사")
    class 유효성_검사 {
        @Test
        @DisplayName("파워는 0과 9사이의 값을 가진다")
        void 파워는_0과_9사이의_값을_가진다() {
            assertThat(Power.from(0)).isNotNull();
            assertThat(Power.from(9)).isNotNull();
        }

        @Test
        @DisplayName("그 이외의 값은 예외를 발생시킨다")
        void 그_이외의_값은_예외를_발생시킨다() {
            assertThatThrownBy(() -> Power.from(-1)).isInstanceOf(
                    IllegalArgumentException.class);
            assertThatThrownBy(() -> Power.from(10)).isInstanceOf(
                    IllegalArgumentException.class);
        }
    }
}
