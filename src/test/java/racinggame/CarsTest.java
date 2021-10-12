package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Map;
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
  void racingCar_1Forward() {
    Map<Integer, Car> racingCars = cars.racing(Arrays.asList(4, 5, 6));
    if(racingCars.values().iterator().hasNext()){
      assertThat(racingCars.values().iterator().next().getCountForward()).isEqualTo(1);
    }
  }

  @Test
  void racingCar_1Forward_2Stop() {
    Map<Integer, Car> racingCars = cars.racing(Arrays.asList(4, 0, 0));
    assertThat(racingCars.get(0).getCountForward()).isEqualTo(1);
    assertThat(racingCars.get(1).getCountForward()).isEqualTo(0);
    assertThat(racingCars.get(2).getCountForward()).isEqualTo(0);
  }

  @Test
  void racingCar_2Forward() {
    cars.racing(Arrays.asList(7, 8, 9));
    Map<Integer, Car> racingCars = cars.racing(Arrays.asList(4, 5, 6));
    if(racingCars.values().iterator().hasNext()){
      assertThat(racingCars.values().iterator().next().getCountForward()).isEqualTo(2);
    }
  }

  @Test
  void racingStop() {
    Map<Integer, Car> racingCars = cars.racing(Arrays.asList(0, 1, 2));
    if(racingCars.values().iterator().hasNext()){
      assertThat(racingCars.values().iterator().next().getCountForward()).isEqualTo(0);
    }
  }

}
