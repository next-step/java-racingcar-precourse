package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @DisplayName("1 미만의 정수를 포지셔닝 할 경우 IllegalArgumentException 발생")
    @Test
    void unsignedPositionException() {
        assertThatThrownBy(() -> {
            new Position(-1);
        })
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Position 객체 생성시 0으로 초기화된다.")
    @Test
    void setPosition() {
        Position position = new Position();

        assertThat(position.getPosition()).isEqualTo(0);
    }

    @DisplayName("Position 도메인 getter로 값을 가져올 수 있다.")
    @Test
    void getPosition() {
        // given
        Position position = new Position(3);

        // then
        assertThat(position.getPosition()).isEqualTo(3);
    }

    @DisplayName("move 함수에 3미만의 값이 전달되면 좌표는 움직이지 않는다.")
    @Test
    void notMoving() {
        // given & when
        Position position = new Position();
        position.moveForward(3);

        // then
        assertThat(position.getPosition()).isEqualTo(0);
    }

    @DisplayName("move 함수에 4 이상의 값이 전달되면 좌표가 움직인다.")
    @Test
    void moving() {
        // given
        Position position = new Position();
        position.moveForward(5);

        // then
        assertThat(position.getPosition()).isEqualTo(1);
    }
}