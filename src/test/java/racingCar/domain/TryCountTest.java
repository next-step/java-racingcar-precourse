package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryCountTest {

  @DisplayName("0보다 작거나 같으면 실행 불가")
  @Test
  void is_continue_race(){
    TryCount tryCount = new TryCount(0);
    assertThatThrownBy(() -> tryCount.decrease())
        .isInstanceOf(AlreadyEndRaceException.class)
        .hasMessage("경기가 끝났습니다");
  }

}