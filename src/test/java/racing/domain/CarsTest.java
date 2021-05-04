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
    Map<String, Integer> position = moveCars.result();
    assertAll(
        () -> assertEquals(position.get("bong"), 1),
        () -> assertEquals(position.get("dong"), 1),
        () -> assertEquals(position.get("jung"), 1)
    );
  }

  @Test
  void getNames() {
    assertThat(cars.getNames()).containsExactly("bong", "dong", "jung");
  }

  @Test
  @DisplayName("우승자를 구한다.")
  void getMaxPosition() {
    Car car1 = new Car("bong");
    car1 = car1.move(() -> true);
    car1 = car1.move(() -> true);
    Car car2 = new Car("dong");
    car2 = car2.move(() -> true);
    car2 = car2.move(() -> true);
    Car car3 = new Car("jung");
    car3 = car3.move(() -> false);
    car3 = car3.move(() -> false);
    Cars cars = new Cars(car1, car2, car3);

    assertThat(cars.getWinner().getNames())
        .containsExactly(car1.name(), car2.name());
  }

}