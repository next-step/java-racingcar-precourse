package racinggame.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static racinggame.model.RacingRoundTotal.INPUT_ERROR_MSG;

class RacingRoundTotalTest {

  @ParameterizedTest(name = "생성 성공 테스트 | {0}")
  @ValueSource(strings = {"1", "2147483647"})
  void racingRoundTotalTest(String round) {
    RacingRoundTotal racingRoundTotal = new RacingRoundTotal(round);
    assertThat(racingRoundTotal.getRound()).isEqualTo(Integer.parseInt(round));
  }

  @ParameterizedTest(name = "생성 실패 테스트 | {0}")
  @ValueSource(strings = {"-1", "0", "a", "2147483648", " "})
  @NullAndEmptySource
  void racingRoundTotalFailTest(String round) {
    assertThatThrownBy(() -> {
      RacingRoundTotal racingRoundTotal = new RacingRoundTotal(round);
    })
        .isInstanceOf(Exception.class)
        .hasMessageContaining(INPUT_ERROR_MSG);

  }
}