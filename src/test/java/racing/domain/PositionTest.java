package racing.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

  @Test
  @DisplayName("move 시, position 이 1높은 객체가 생성된다.")
  void move() {
    Position position = new Position();
    Position movePosition = position.move();
    assertAll(
        () -> assertEquals(position.getPosition(), 0),
        () -> assertEquals(movePosition.getPosition(), 1)
    );
  }
}