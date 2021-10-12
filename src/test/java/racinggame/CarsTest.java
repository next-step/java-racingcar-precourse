package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
  @DisplayName("모든_레이싱차_1번_전진")
  void allRacingCar_1Forward() {
    RacingResult result = cars.racing(Arrays.asList(4, 5, 6));
    if(result.getCars().iterator().hasNext()){
      assertThat(result.getCars().iterator().next().getCountForward()).isEqualTo(1);
    }
  }

  @Test
  @DisplayName("레이싱차_1대_전진_2대_정지")
  void racingCar_1Forward_2Stop() {
    RacingResult result = cars.racing(Arrays.asList(4, 0, 0));
    assertThat(result.getCars().get(0).getCountForward()).isEqualTo(1);
    assertThat(result.getCars().get(1).getCountForward()).isEqualTo(0);
    assertThat(result.getCars().get(2).getCountForward()).isEqualTo(0);
  }

  @Test
  @DisplayName("모든_레이싱차_2번_전진")
  void allRacingCar_2Forward() {
    cars.racing(Arrays.asList(7, 8, 9));
    RacingResult result = cars.racing(Arrays.asList(4, 5, 6));
    if(result.getCars().iterator().hasNext()){
      assertThat(result.getCars().iterator().next().getCountForward()).isEqualTo(2);
    }
  }

  @Test
  @DisplayName("모든_레이싱차_정지")
  void allRacingStop() {
    RacingResult result = cars.racing(Arrays.asList(0, 1, 2));
    if(result.getCars().iterator().hasNext()){
      assertThat(result.getCars().iterator().next().getCountForward()).isEqualTo(0);
    }
  }

}
