package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {

    @DisplayName("position 객체를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void construct(int positionIndex) {
        Position position = new Position(positionIndex);
        assertThat(position).isNotNull();
    }

    @DisplayName("position은 0이상의 숫자만 입력 가능하다.")
    @Test
    void constructWithNegativeNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Position(-1))
                .withMessageContaining("자동차의 위치는 음수가 될 수 없습니다.");
    }

    @DisplayName("FunctionalInterface를 통한 move() 테스트 수행 ")
    @Test
    void moveWithMovingStrategy() {
        Position position = new Position(0);
        assertThat(position.move(() -> true)).isEqualTo(new Position(1));
    }

    @DisplayName("cache 된 값으로 응답받는지 확인한다.")
    @Test
    void cachedPosition() {
        Position position1 = new Position(0);
        Position position2 = new Position(0);

        assertNotSame(position1, position2);
        assertSame(position1.cachedPosition(), position2.cachedPosition());
    }

    @DisplayName("자동차가 가장 멀리 움직였는지 확인한다.")
    @Test
    void isMaxPosition() {
        Position position = new Position(3);
        assertAll(
                () -> assertThat(position.isMaxPosition(2)).isTrue(),
                () -> assertThat(position.isMaxPosition(3)).isTrue(),
                () -> assertThat(position.isMaxPosition(4)).isFalse()
        );
    }
}
