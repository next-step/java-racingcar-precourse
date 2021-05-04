package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

  private Cars cars;

  @BeforeEach
  void dummy() {
    Car car1 = new Car("bong");
    Car car2 = new Car("dong");
    Car car3 = new Car("jung");
    cars = new Cars(car1, car2, car3);
  }

  @Test
  @DisplayName("movable 전부 true 시, 1칸씩 전진")
  void moveByStrategy() {
    Cars moveCars = this.cars.moveByStrategy(() -> true);
    Map<String, Integer> position = moveCars.position();
    assertAll(
        () -> assertEquals(position.get("bong"), 1),
        () -> assertEquals(position.get("dong"), 1),
        () -> assertEquals(position.get("jung"), 1)
    );
  }

}