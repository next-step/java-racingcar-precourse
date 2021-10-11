package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author : naming
 * @packageName : racinggame
 * @date : 2021/10/11
 * @description :
 */
public class CarTest {

  private Car car;

  @BeforeEach
  void setUp() {
    car = new Car("volvo");
  }

  @Test
  void carMoveForward() {
    assertThat(car.racing(4)).isEqualTo(CarMoveStatus.FORWARD);
    assertThat(car.racing(9)).isEqualTo(CarMoveStatus.FORWARD);
  }

  @Test
  void carMoveStop() {
    assertThat(car.racing(0)).isEqualTo(CarMoveStatus.STOP);
    assertThat(car.racing(3)).isEqualTo(CarMoveStatus.STOP);
  }

  @Test
  @DisplayName("자동차_전진횟수")
  void countCarForward() {
    car.racing(4);
    car.racing(5);
    car.racing(6);
    assertThat(car.getCountForward()).isEqualTo(3);
  }
}
