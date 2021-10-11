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
    List<Car> racingCars = cars.racing(Arrays.asList(4, 5, 6));
    for(Car car : racingCars) {
      assertThat(car.getCountForward()).isEqualTo(1);
    }
  }

  @Test
  void racingStop() {
    List<Car> racingCars = cars.racing(Arrays.asList(0, 1, 2));
    for(Car car : racingCars) {
      assertThat(car.getCountForward()).isEqualTo(0);
    }
  }

}
