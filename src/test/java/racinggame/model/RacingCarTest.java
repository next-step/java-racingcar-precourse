package racinggame.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import java.util.Map;
import nextstep.utils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racinggame.enums.Errors;
import racinggame.exception.RacingCarGameException;

class RacingCarTest {

  @Test
  @DisplayName("5자가 넘어가는 자동차명")
  void racingCar_with_5length() {
    assertThatThrownBy(() -> new RacingCar("pobiii,crong,honux"))
        .as(Errors.E00001.getMessage())
        .isInstanceOf(RacingCarGameException.class);
  }

  @Test
  @DisplayName("정상 자동차명")
  void racingCar_success() {
    new RacingCar("pobi,crong,honux");
  }

  @Test
  @DisplayName("승자가 1명인 경우")
  void success_with_winner1() {
    try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
      mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
          .thenReturn(1,2,4);

      RacingCar racingCar = new RacingCar("pobi,crong,honux");
      racingCar.race();

      Map<String, Integer> locationOfCars = racingCar.getLocationOfCars();
      assertThat(racingCar.winner()).isEqualTo("honux");
      assertThat(locationOfCars.get("pobi")).isEqualTo(0);
      assertThat(locationOfCars.get("crong")).isEqualTo(0);
      assertThat(locationOfCars.get("honux")).isEqualTo(1);
    }
  }

  @Test
  @DisplayName("승자가 2명인 경우")
  void success_with_winner2() {
    try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
      mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
          .thenReturn(1,4,4);

      RacingCar racingCar = new RacingCar("pobi,crong,honux");
      racingCar.race();

      Map<String, Integer> locationOfCars = racingCar.getLocationOfCars();
      assertThat(racingCar.winner()).isEqualTo("crong,honux");
      assertThat(locationOfCars.get("pobi")).isEqualTo(0);
      assertThat(locationOfCars.get("crong")).isEqualTo(1);
      assertThat(locationOfCars.get("honux")).isEqualTo(1);
    }
  }
}
