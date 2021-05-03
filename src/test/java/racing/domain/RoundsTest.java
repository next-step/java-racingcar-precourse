package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.exception.InvalidRoundTotalSizeException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RoundsTest {

  @Test
  @DisplayName("총 라운드에 대한 자동차들의 레이싱 결과를 생성한다.")
  void generate() {
    // given
    int countOfTotal = 3;
    Cars cars = Cars.generateFromInputString("gmoon,guest");

    // when
    Rounds actual = Rounds.generate(countOfTotal, cars);

    // then
    assertThat(actual.getValues()).hasSize(countOfTotal);
  }

  @Test
  @DisplayName("총 라운드 일급 컬렉션은 최소 " + Rounds.MIN + "개 이상의 라운드가 필요하다.")
  void generate_error() {
    // given
    Cars cars = Cars.generateFromInputString("gmoon,guest");

    // then
    assertThatExceptionOfType(InvalidRoundTotalSizeException.class)
            .isThrownBy(() -> Rounds.generate(Rounds.MIN - 1, cars))
            .withMessageMatching("최소한 \\d+ 이상의 라운드가 필요합니다.");
  }

  @Test
  @DisplayName("마지막 라운드를 반환한다.")
  void finalRound() {
    // given
    int countOfTotal = 2;
    Rounds rounds = Rounds.generate(countOfTotal, Cars.generateFromInputString("gmoon,guest"));

    // when
    Round finalRound = rounds.finalRound();

    // then
    assertThat(finalRound).isEqualTo(rounds.getValues().get(countOfTotal - 1));
  }
}