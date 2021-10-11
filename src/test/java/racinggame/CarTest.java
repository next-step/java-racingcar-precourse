package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * @author : naming
 * @packageName : racinggame
 * @date : 2021/10/11
 * @description :
 */
public class CarTest {

  @Test
  void carMove() {
    Car car = new Car("volvo");
    assertThat(car.racing(4)).isEqualTo(CarMoveStatus.FORWARD);
    assertThat(car.racing(0)).isEqualTo(CarMoveStatus.STOP);
  }

}
