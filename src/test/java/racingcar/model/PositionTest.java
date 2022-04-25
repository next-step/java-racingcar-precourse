package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {
    @DisplayName("포지션을 생성할 때, 포지션 값 등록이 성공한다.")
    @Test
    void setPositionSuccess_P01() {
        Position position = new Position(1);
        assertThat(position.getPosition()).isEqualTo(1);
    }

    @DisplayName("포지션에 값을 추가할 때, 포지션 값 등록이 성공한다.")
    @Test
    void setPositionSuccess_P02() {
        Position position = new Position(1);
        position.setPosition(2);
        assertThat(position.getPosition()).isEqualTo(3);
    }

    @DisplayName("포지션 끼리 비교했을 때, 같은 값을 가지면 equal함수는 true")
    @Test
    void equalToReturnTrue_P01() {
        Position position = new Position(1);
        Position other = new Position(1);
        assertThat(position.equals(other)).isTrue();
        assertThat(other.equals(position)).isTrue();
    }

    @DisplayName("포지션 끼리 비교했을 때, 다른 값을 가지면 equal함수는 false")
    @Test
    void equalToReturnFalse_N01() {
        Position position = new Position(1);
        Position other = new Position(2);
        assertThat(position.equals(other)).isFalse();
        assertThat(other.equals(position)).isFalse();
    }


    @DisplayName("다른 객체와 비교했을 때, equal함수는 false")
    @Test
    void equalToReturnFalse_N03() {
        Position position = new Position(1);
        Object other = new Object();
        assertThat(position.equals(other)).isFalse();
        assertThat(other.equals(position)).isFalse();
    }
}
