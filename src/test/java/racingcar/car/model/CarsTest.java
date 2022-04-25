package racingcar.car.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

  @DisplayName("이름이 담겨있는 배열을 넘겨주면 Cars 객체를 만들 수 있다.")
  @Test
  void carsTest() {
    // given
    String[] input = {"a", "b", "c"};

    // when
    Cars cars = new Cars(input);

    // then
    assertThat(cars.get(0).getName()).isEqualTo(input[0]);
    assertThat(cars.get(1).getName()).isEqualTo(input[1]);
    assertThat(cars.get(2).getName()).isEqualTo(input[2]);
  }

  @DisplayName("Cars 객체에서 가장 높은 점수를 가져올 수 있다.")
  @Test
  void getHighestScoreTest() {
    // given
    String[] input = {"a", "b", "c"};
    Cars cars = new Cars(input);
    Racing racing = new Racing(cars);

    // when
    for (int i = 0; i < 5; i++) {
      racing.play();
    }

    // then
    int highestScore = cars.getHighestScore();
    Collections.sort(cars.getCars());
    assertThat(highestScore).isEqualTo(cars.get(0).getHistorySize());
  }
}