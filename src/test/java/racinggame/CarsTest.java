package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * @author : naming
 * @packageName : racinggame
 * @date : 2021/10/11
 * @description :
 */
public class CarsTest {

  @Test
  void racingTest() {
    Cars cars = new Cars(Arrays.asList(new Car("kia"), new Car("volvo"), new Car("benz")));
    List<CarMoveStatus> racingCars = cars.racing(Arrays.asList(4,1,2));
    assertThat(racingCars.get(0)).isEqualTo(CarMoveStatus.FORWARD);
    assertThat(racingCars.get(1)).isEqualTo(CarMoveStatus.STOP);
    assertThat(racingCars.get(2)).isEqualTo(CarMoveStatus.STOP);
  }

}
