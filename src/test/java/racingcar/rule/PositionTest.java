package racingcar.rule;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class PositionTest {

    @DisplayName("초기 값은 0이다")
    @Test
    void initialValueIsZero() {
        //given
        Position position = Position.init();

        //when
        int initialValue = position.get();

        //then
        assertThat(initialValue).isZero();
    }

    @DisplayName("값을 증가할 수 있다")
    @Test
    void increase() {
        //given
        Position position = Position.init();

        //when
        position.increase();
        int increasePosition = position.get();

        //then
        assertThat(increasePosition).isOne();
    }

    @Test
    void comparable() {
        //given
        Position position1 = new Position(1);
        Position position2 = new Position(2);
        Position position3 = new Position(3);

        //when
        List<Position> positions = Arrays.asList(position3, position2, position1);
        Collections.sort(positions);

        //then
        assertThat(positions).containsExactly(position1, position2, position3);
    }

    @DisplayName("natural ordering과 equals가 일치하도록 권장된다")
    @Test
    void comparableAndEquality() {
        //given
        int number = 1;

        //when
        Position position = new Position(number);
        Position other = new Position(number);

        //then
        assertThat(position)
                .isEqualTo(other)
                .hasSameHashCodeAs(other)
                .isEqualByComparingTo(other);
    }

    @DisplayName("최소 값보다 작은 경우 예외가 발생한다")
    @Test
    void throwExceptionWhenLessThanMin() {
        //given
        int lessThanMin = -1;

        //when
        Throwable thrown = catchThrowable(() -> new Position(lessThanMin));

        //then
        assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("위치는 0 이상이어야 한다.");
    }
}
