package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.exception.PositionLessThenMinValueException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

class PositionTest {

  @Test
  @DisplayName("자동차 위치는 최소 0 이상을 갖는다.")
  void newInstance() {
    assertAll(
            () -> assertThat(Position.create()).isEqualTo(new Position(Position.MIN)),
            () -> assertThatExceptionOfType(PositionLessThenMinValueException.class)
                    .isThrownBy(() -> new Position(Position.MIN - 1))
                    .withMessageMatching("최소 위치\\(\\d+\\)가 필요합니다.")
    );
  }

  @Test
  @DisplayName("자동차 위치가 전진한다.")
  void move() {
    // given
    Position position = Position.create();

    // when
    Position actual = position.move();

    // then
    assertThat(actual)
            .isEqualTo(new Position(Position.MIN + 1));
  }

  @Test
  @DisplayName("int 타입의 매개 변수와 비교하여 큰 수를 반환한다.")
  void max() {
    // given
    int other = 1;
    Position min = Position.create();

    // when
    Position actual = min.max(other);

    //
    assertThat(actual).isEqualTo(Position.create().move());
  }
}