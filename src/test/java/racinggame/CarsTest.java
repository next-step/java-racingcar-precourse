package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author : naming
 * @packageName : racinggame
 * @date : 2021/10/11
 * @description :
 */
public class CarsTest {

  private Cars cars;

  @BeforeEach
  void setUp() {
    cars = new Cars(Arrays.asList(new Car("kia"), new Car("volvo"), new Car("benz")));
  }

  @Test
  void racingForward() {
    List<CarMoveStatus> racingCars = cars.racing(Arrays.asList(4, 4, 4));
    for(CarMoveStatus carMoveStatus : racingCars) {
      assertThat(carMoveStatus).isEqualTo(CarMoveStatus.FORWARD);
    }
  }

  @Test
  void racingStop() {
    List<CarMoveStatus> racingCars = cars.racing(Arrays.asList(0, 0, 0));
    for(CarMoveStatus carMoveStatus : racingCars) {
      assertThat(carMoveStatus).isEqualTo(CarMoveStatus.STOP);
    }
  }

}
