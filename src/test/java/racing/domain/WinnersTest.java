package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

  @Test
  @DisplayName("해당 라운드의 우승자를 구한다.")
  void generate() {
    // given
    Cars cars = Cars.generateFromInputString("gmoon").race(() -> true);
    Round round = Round.record(cars);

    // when
    Winners actual = Winners.generate(round);

    // then
    assertThat(actual.getValues())
            .containsExactly(new Car("gmoon").move(() -> true));
  }
}