package racingcar.car.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

  @DisplayName("Cars 객체를 전달받아 결과를 계산할 수 있다.")
  @Test
  void resultTest() {
    // given
    String[] input = {"a", "b", "c"};
    Cars cars = new Cars(input);

    Car winner = cars.get(0);

    // when
    winner.runOrStopByNumber(7);
    Result result = new Result(cars);

    // then
    assertThat(result.getWinnerNames()).isEqualTo(Lists.list(winner.getName()));
    assertThat(result.getWinnerNames().size()).isEqualTo(1);
  }

  @DisplayName("동점인 경우에 리스트에 2개 이상의 이름이 들어간다")
  @Test
  void tiedTest() {
    // given
    String[] input = {"a", "b", "c"};
    Cars cars = new Cars(input);

    Car winner = cars.get(0);
    Car tied = cars.get(1);

    // when
    winner.runOrStopByNumber(7);
    tied.runOrStopByNumber(6);
    Result result = new Result(cars);

    // then
    assertThat(result.getWinnerNames()).isEqualTo(Lists.list(winner.getName(), tied.getName()));
    assertThat(result.getWinnerNames().size()).isEqualTo(2);
  }

}