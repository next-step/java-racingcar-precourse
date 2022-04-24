package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("초기 위치는 0이다.")
    void initPositionZero() {
        Position position = Position.create();
        assertThat(position.getValue()).isZero();
    }

    @Test
    @DisplayName("위치값을 설정한다.")
    void settingPositionValue() {
        Position position = Position.valueOf(6);
        assertThat(position.getValue()).isEqualTo(6);
    }

    @Test
    @DisplayName("움직이면 위치는 1만큼 증가한다.")
    void movePositionThen() {
        Position position = Position.create();
        position.moveValue();

        assertAll(
                () -> assertThat(position.getValue()).isNotZero(),
                () -> assertThat(position.getValue()).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("두 위치를 비교하여 더 큰 위치를 반환한다")
    void compareTwoPosition() {
        Position positionOf10 = Position.valueOf(10);
        Position positionOf5 = Position.valueOf(5);

        assertAll(
                () -> assertThat(positionOf10.getMorePosition(positionOf5).getValue()).isEqualTo(10),
                () -> assertThat(positionOf5.getMorePosition(positionOf10).getValue()).isEqualTo(10)
        );
    }
}
