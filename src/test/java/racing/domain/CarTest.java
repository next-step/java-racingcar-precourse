package racing.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

  @Test
  @DisplayName("전진테스트")
  void move() {
    Car car = new Car("cyr");
    car = car.move(() -> true);
    assertEquals(car.position(), 1);
  }

  @Test
  @DisplayName("4 미만일 때, 정지")
  void stop() {
    Car car = new Car("cyr");
    car = car.move(() -> false);
    assertEquals(car.position(), 0);
  }

}